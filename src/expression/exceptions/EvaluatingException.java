package expression.exceptions;

/**
 * Evaluating exception
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class EvaluatingException extends Exception {
    /**
     * Creates evaluating exception by message
     *
     * @param message about an error
     */
    public EvaluatingException(final String message) {
        super(message);
    }
}