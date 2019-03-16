package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

public class Mod<T> extends AbstractBinaryOperator<T> {
    public Mod(TripleExpression<T> arg1, TripleExpression<T> arg2, Type<T> type) {
        super(arg1, arg2, type);
    }

    @Override
    protected T operator(T arg1, T arg2) throws EvaluatingException {
        return type.mod(arg1, arg2);
    }
}
