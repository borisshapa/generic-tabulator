package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

/**
 * Negation operation.
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Neg<T> extends AbstractUnaryOperator<T> {
    /**
     * Creates negation operation.
     *
     * @param x argument
     * @param type type in which to calculate the value
     */
    public Neg(TripleExpression<T> x, Type<T> type) {
        super(x, type);
    }

    @Override
    protected T operator(T arg) throws OverflowException {
        return type.neg(arg);
    }
}