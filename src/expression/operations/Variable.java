package expression.operations;

public class Variable<T> implements TripleExpression<T> {
    private final String variable;

    public Variable(String string) {
        variable = string;
    }

    public T evaluate(final T x, final T y, final T z) {
        switch (variable) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new AssertionError();
        }
    }
}