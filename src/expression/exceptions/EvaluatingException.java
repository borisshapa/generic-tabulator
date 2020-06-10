package expression.exceptions;

public class EvaluatingException extends Exception {
    public EvaluatingException(final String message) {
        super(message);
    }

    public EvaluatingException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}