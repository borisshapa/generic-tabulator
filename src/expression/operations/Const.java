package expression.operations;

/**
 * Constant
 *
 * @param <T> constant type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Const<T> implements TripleExpression<T> {
    private final T value;

    /**
     * Creates a constant.
     *
     * @param x the constant value
     */
    public Const(T x) {
        value = x;
    }

    @Override
    public T evaluate(final T x, final T y, final T z) {
        return value;
    }
}