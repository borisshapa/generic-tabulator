package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

/**
 * Squaring operation.
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Square<T> extends AbstractUnaryOperator<T> {
    /**
     * Creates squaring operation.
     *
     * @param arg  argument
     * @param type type in which to calculate the value
     */
    public Square(TripleExpression<T> arg, Type<T> type) {
        super(arg, type);
    }

    @Override
    protected T operator(T x) throws EvaluatingException {
        return type.square(x);
    }
}
