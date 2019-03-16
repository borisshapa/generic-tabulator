package expression.parser;

public class SourceException extends Throwable {
    private final int pos;
    private final int line;

    public SourceException(final int line, final int pos, final String message) {
        super(message);
        this.line = line;
        this.pos = pos;
    }

    public int getPosition() {
        return pos;
    }

    public int getLine() {
        return line;
    }
}