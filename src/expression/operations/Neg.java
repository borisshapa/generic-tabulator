package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

public class Neg<T> extends AbstractUnaryOperator<T> {
    protected T operator(T arg) throws OverflowException {
        return type.neg(arg);
    }
    public Neg(TripleExpression<T> x, Type<T> type) {
        super(x, type);
    }
}