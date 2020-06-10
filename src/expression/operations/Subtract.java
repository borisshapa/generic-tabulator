package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

/**
 * Subtraction operation.
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Subtract<T> extends AbstractBinaryOperator<T> {
    /**
     * Creates subtraction operation.
     *
     * @param a    minuend
     * @param b    subtrahend
     * @param type type in which to calculate the value
     */
    public Subtract(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }

    @Override
    protected T operator(T a, T b) throws OverflowException {
        return type.subtract(a, b);
    }
}