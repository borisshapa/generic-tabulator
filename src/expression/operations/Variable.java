package expression.operations;

/**
 * Variable
 *
 * @param <T> variable type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Variable<T> implements TripleExpression<T> {
    private final String variable;

    /**
     * Creates variable with passed name.
     *
     * @param string variable name
     */
    public Variable(String string) {
        variable = string;
    }

    public T evaluate(final T x, final T y, final T z) {
        switch (variable) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new AssertionError();
        }
    }
}