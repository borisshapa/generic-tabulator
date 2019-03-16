package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

public class Multiply<T> extends AbstractBinaryOperator<T> {
    protected T operator(T a, T b) throws OverflowException {
        return type.multiply(a, b);
    }

    public Multiply(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }
}