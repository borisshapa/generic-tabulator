package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

/**
 * Module operation.
 *
 * @param <T> argument type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Abs<T> extends AbstractUnaryOperator<T> {
    /**
     * Creates module operation.
     *
     * @param arg  argument
     * @param type type in which to calculate the value
     */
    public Abs(TripleExpression<T> arg, Type<T> type) {
        super(arg, type);
    }

    @Override
    protected T operator(T arg) throws EvaluatingException {
        return type.abs(arg);
    }
}
