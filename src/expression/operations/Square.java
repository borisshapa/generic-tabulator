package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

public class Square<T> extends AbstractUnaryOperator<T> {
    public Square(TripleExpression<T> arg, Type<T> type) {
        super(arg, type);
    }

    @Override
    protected T operator(T x) throws EvaluatingException {
        return type.square(x);
    }
}
