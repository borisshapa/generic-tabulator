package expression.parser;

import expression.types.Type;
import expression.operations.*;

public class ExpressionParser<T> implements Parser<T> {
    private Source source;
    private Type<T> type;

    public ExpressionParser(Type<T> op) {
        type = op;
    }

    private void skipSpaces() throws SourceException {
        while (Character.isWhitespace(source.getChar())) {
            source.nextChar();
        }
    }

    private TripleExpression<T> parseAddSub() throws SourceException {
        TripleExpression<T> ans = parseMulDiv();
        while (true) {
            skipSpaces();
            if (testNext('+')) {
                ans = new Add<>(ans, parseMulDiv(), type);
            } else if (testNext('-')) {
                ans = new Subtract<>(ans, parseMulDiv(), type);
            } else {
                return ans;
            }
        }
    }

    private TripleExpression<T> parseMulDiv() throws SourceException {
        TripleExpression<T> ans = parsePrimary();
        while (true) {
            skipSpaces();
            if (testNext('*')) {
                ans = new Multiply<>(ans, parsePrimary(), type);
            } else if (testNext('/')) {
                ans = new Divide<>(ans, parsePrimary(), type);
            } else if (test('m') && parseIdentifier().equals("mod")) {
                ans = new Mod<>(ans, parsePrimary(), type);
            } else {
                return ans;
            }
        }
    }

    private TripleExpression<T> parsePrimary() throws SourceException {
        skipSpaces();
        if (Character.isDigit(source.getChar()) || test('-')) {
            return parseConst();
        } else if (testNext('(')) {
            TripleExpression<T> ans = parseAddSub();
            expect(')', ")");
            return ans;
        } else if (Character.isLetter(source.getChar())) {
            final String identifier = parseIdentifier();
            TripleExpression<T> ans;
            switch (identifier) {
                case "x":
                case "y":
                case "z":
                    ans = new Variable<>(identifier);
                    break;
                case "abs":
                    ans = new Abs<>(parsePrimary(), type);
                    break;
                case "square":
                    ans = new Square<>(parsePrimary(), type);
                    break;
                default:
                    throw source.error("Expected variable or unary operation, found '%s'", identifier);
            }
            return ans;
        } else {
            throw source.error("Expected primary expression, found '%c'", source.getChar());
        }
    }

    private TripleExpression<T> parseConst() throws SourceException {
        final StringBuilder sb = new StringBuilder();
        sb.append(source.getChar());
        skipSpaces();
        while (Character.isDigit(source.nextChar())) {
            sb.append(source.getChar());
        }
        try {
            return new Const<>(type.parseNumber(sb.toString()));
        } catch (final NumberFormatException e) {
            throw source.error("Invalid number '%s'", sb);
        }
    }

    private boolean testNext(char c) throws SourceException {
        if (source.getChar() == c) {
            source.nextChar();
            return true;
        } else {
            return false;
        }
    }

    private boolean test(char c) {
        return source.getChar() == c;
    }


    private void expect(char expected, String errorMessage) throws SourceException {
        final char actual = source.getChar();
        if (actual == expected) {
            if (expected != Source.END) {
                source.nextChar();
            }
        } else if (actual != Source.END) {
            throw source.error("Expected %s, found '%s' (%d)", errorMessage, actual, (int) actual);
        } else {
            throw source.error("Expected %s, found EOF", errorMessage);
        }
    }

    private String parseIdentifier() throws SourceException {
        final StringBuilder sb = new StringBuilder();
        while (Character.isLetterOrDigit(source.getChar())) {
            sb.append(source.getChar());
            source.nextChar();
        }
        return sb.toString();
    }


    @Override
    public TripleExpression<T> parse(String expression) throws SourceException {
        source = new StringSource(expression);
        source.nextChar();
        TripleExpression<T> ans = parseAddSub();
        skipSpaces();
        expect(Source.END, "end of file");
        return ans;
    }
}