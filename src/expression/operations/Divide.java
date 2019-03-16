package expression.operations;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;
import expression.types.Type;

public class Divide<T> extends AbstractBinaryOperator<T> {
    protected T operator(T a, T b) throws DivisionByZeroException, OverflowException {
        return type.divide(a, b);
    }
    public Divide(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }
}