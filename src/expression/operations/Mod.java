package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

/**
 * Remainder operation
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Mod<T> extends AbstractBinaryOperator<T> {
    /**
     * Creates a reminder operation
     *
     * @param arg1 divided
     * @param arg2 divider
     * @param type type in which to calculate the value
     */
    public Mod(TripleExpression<T> arg1, TripleExpression<T> arg2, Type<T> type) {
        super(arg1, arg2, type);
    }

    @Override
    protected T operator(T arg1, T arg2) throws EvaluatingException {
        return type.mod(arg1, arg2);
    }
}
