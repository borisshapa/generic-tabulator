package expression.types;

import expression.parser.Source;
import expression.parser.SourceException;

public class DoubleType implements Type<Double> {

    @Override
    public Double add(Double arg1, Double arg2) {
        return arg1 + arg2;
    }

    @Override
    public Double subtract(Double arg1, Double arg2) {
        return arg1 - arg2;
    }

    @Override
    public Double multiply(Double arg1, Double arg2) {
        return arg1 * arg2;
    }

    @Override
    public Double divide(Double arg1, Double arg2) {
        return arg1 / arg2;
    }

    @Override
    public Double neg(Double arg) {
        return -arg;
    }

    @Override
    public Double parseNumber(String arg) throws SourceException {
        try {
            return Double.parseDouble(arg);
        } catch (NumberFormatException e) {
            throw new SourceException(Source.line, Source.posInLine, "Unexpected argument");
        }
    }

    @Override
    public Double abs(Double arg) {
        return (arg < 0) ? -arg : arg;
    }

    @Override
    public Double square(Double arg) {
        return arg * arg;
    }

    @Override
    public Double mod(Double arg1, Double arg2) {
        return arg1 % arg2;
    }
}
