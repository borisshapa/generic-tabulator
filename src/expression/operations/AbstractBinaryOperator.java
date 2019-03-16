package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

public abstract class AbstractBinaryOperator<T> implements TripleExpression<T> {
    private final TripleExpression<T> arg1, arg2;
    protected final Type<T> type;

    public AbstractBinaryOperator(TripleExpression<T> arg1, TripleExpression<T> arg2, Type<T> type) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.type = type;
    }

    protected abstract T operator(T arg1, T arg2) throws EvaluatingException;

    @Override
    public T evaluate(T x, T y, T z) throws EvaluatingException {
        return operator(arg1.evaluate(x, y, z), arg2.evaluate(x, y, z));
    }
}