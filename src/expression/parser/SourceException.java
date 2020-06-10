package expression.parser;

/**
 * Parsing exception
 */
public class SourceException extends Throwable {
    private final int pos;
    private final int line;

    /**
     * Creates an parsing exception
     *
     * @param line    the line number on which the error occurred.
     * @param pos     the position in the line where the error occurred.
     * @param message error message
     */
    public SourceException(final int line, final int pos, final String message) {
        super(message);
        this.line = line;
        this.pos = pos;
    }

    /**
     * Returns the position in the line where the error occurred.
     *
     * @return error position in line
     */
    public int getPosition() {
        return pos;
    }

    /**
     * Returns the line number on which the error occurred.
     *
     * @return error line
     */
    public int getLine() {
        return line;
    }
}