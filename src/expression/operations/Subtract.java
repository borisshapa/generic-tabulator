package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

public class Subtract<T> extends AbstractBinaryOperator<T> {
    protected T operator(T a, T b) throws OverflowException {
        return type.subtract(a, b);
    }
    public Subtract(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }
}