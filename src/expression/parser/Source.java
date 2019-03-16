package expression.parser;

import java.io.IOException;

public abstract class Source {
    public static char END = '\0';

    int pos;
    public static int line = 1;
    public static int posInLine;
    private char c;

    protected abstract char readChar() throws IOException;

    public char getChar() {
        return c;
    }

    public char nextChar() throws SourceException {
        try {
            if (c == '\n') {
                line++;
                posInLine = 0;
            }
            c = readChar();
            pos++;
            posInLine++;
            return c;
        } catch (final IOException e) {
            throw error("Source read error", e.getMessage());
        }
    }

    public SourceException error(final String format, final Object... args) throws SourceException {
        return new SourceException(line, posInLine, String.format("%d:%d: %s", line, posInLine, String.format(format, args)));
    }
}