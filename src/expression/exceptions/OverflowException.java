package expression.exceptions;

public class OverflowException extends EvaluatingException {
    private static final String message = "overflow";

    public OverflowException() {
        super("overflow");
    }

    public OverflowException(Throwable throwable) {
        super(message, throwable);
    }
}