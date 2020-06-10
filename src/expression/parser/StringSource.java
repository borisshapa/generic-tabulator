package expression.parser;

/**
 * String where to get characters.
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class StringSource extends Source {
    private final String data;

    /**
     * Constructs a new StringSource, where to get characters.
     *
     * @param data string to get around.
     */
    public StringSource(final String data) {
        this.data = data + END;
    }

    @Override
    protected char readChar() {
        return data.charAt(pos);
    }
}