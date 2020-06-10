package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

/**
 * Addition operation.
 *
 * @param <T> argument type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Add<T> extends AbstractBinaryOperator<T> implements TripleExpression<T> {
    /**
     * Creates an addition operation.
     *
     * @param a    left term
     * @param b    right term
     * @param type type in which to calculate the value
     */
    public Add(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }

    @Override
    protected T operator(T arg1, T arg2) throws OverflowException {
        return type.add(arg1, arg2);
    }
}