package expression.operations;

import expression.exceptions.OverflowException;
import expression.types.Type;

public class Add<T> extends AbstractBinaryOperator<T> implements TripleExpression<T> {
    protected T operator(T arg1, T arg2) throws OverflowException {
        return type.add(arg1, arg2);
    }
    public Add(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }
}