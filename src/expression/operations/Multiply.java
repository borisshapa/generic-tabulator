package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

/**
 * Multiplication operation.
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Multiply<T> extends AbstractBinaryOperator<T> {
    /**
     * Creates a multiplication operation.
     *
     * @param a first multiplier
     * @param b second multiplier
     * @param type type in which to calculate the value
     */
    public Multiply(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }

    @Override
    protected T operator(T a, T b) throws OverflowException {
        return type.multiply(a, b);
    }
}