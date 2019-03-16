package expression.parser;

public class StringSource extends Source {
    private final String data;

    public StringSource(final String data) {
        this.data = data + END;
    }

    @Override
    protected char readChar() {
        return data.charAt(pos);
    }
}