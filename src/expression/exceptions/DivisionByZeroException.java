package expression.exceptions;

/**
 * Division by zero exception
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class DivisionByZeroException extends EvaluatingException {
    /**
     * Error message
     */
    private static final String MESSAGE = "division by zero";

    /**
     * Creates division by zero exception
     */
    public DivisionByZeroException() {
        super(MESSAGE);
    }
}