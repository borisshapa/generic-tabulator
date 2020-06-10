package expression.exceptions;

/**
 * Overflow exception
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class OverflowException extends EvaluatingException {
    /**
     * Creates overflow exception
     */
    public OverflowException() {
        super("overflow");
    }
}