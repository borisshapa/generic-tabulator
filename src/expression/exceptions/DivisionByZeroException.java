package expression.exceptions;

public class DivisionByZeroException extends EvaluatingException {
    private static final String message = "division by zero";

    public DivisionByZeroException() {
        super(message);
    }

    public DivisionByZeroException(Throwable throwable) {
        super(message, throwable);
    }
}