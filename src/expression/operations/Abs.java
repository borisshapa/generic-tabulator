package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

public class Abs<T> extends AbstractUnaryOperator<T> {
    public Abs(TripleExpression<T> arg, Type<T> type) {
        super(arg, type);
    }

    protected T operator(T arg) throws EvaluatingException {
        return type.abs(arg);
    }
}
