package expression.parser;

import java.io.IOException;

/**
 * Source where to get characters.
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public abstract class Source {
    /**
     * End of array operations sequence.
     */
    public static char END = '\0';

    int pos;
    public static int line = 1;
    public static int posInLine;
    private char c;

    protected abstract char readChar() throws IOException;

    public char getChar() {
        return c;
    }

    /**
     * Returns a next character.
     *
     * @return next character
     */
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

    /**
     * Returns an expression parsing error.
     *
     * @param format error message string format
     * @param args   arguments to substitute in the format of the error message.
     * @return {@link SourceException} with information about the error and the place where it occurred.
     */
    public SourceException error(final String format, final Object... args) {
        return new SourceException(line, posInLine, String.format("%d:%d: %s", line, posInLine, String.format(format, args)));
    }
}