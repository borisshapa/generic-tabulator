package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

public abstract class AbstractUnaryOperator<T> implements TripleExpression<T>{
    private final TripleExpression<T> arg;
    protected Type<T> type;

    public AbstractUnaryOperator(TripleExpression<T> arg, Type<T> type) {
        this.arg = arg;
        this.type = type;
    }

    protected abstract T operator(T x) throws EvaluatingException;

    @Override
    public T evaluate(T x, T y, T z) throws EvaluatingException {
        return operator(arg.evaluate(x, y, z));
    }
}
