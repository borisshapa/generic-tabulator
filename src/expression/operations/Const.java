package expression.operations;

public class Const<T> implements TripleExpression<T> {
    private T value;

    public Const(T x) {
        value = x;
    }

    public T evaluate(final T x, final T y, final T z) {
        return  value;
    }
}