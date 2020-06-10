package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

/**
 * Unary operator class
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public abstract class AbstractUnaryOperator<T> implements TripleExpression<T> {
    private final TripleExpression<T> arg;
    /**
     * The type in which the expression is evaluated
     */
    protected Type<T> type;

    /**
     * Creates an unary operator
     *
     * @param arg  argument
     * @param type type in which the expression is evaluated
     */
    public AbstractUnaryOperator(TripleExpression<T> arg, Type<T> type) {
        this.arg = arg;
        this.type = type;
    }

    /**
     * The calculation of the unary operation value.
     *
     * @param x argument
     * @return operation evaluation result
     * @throws EvaluatingException if an error occurred while evaluating the expression.
     */
    protected abstract T operator(T x) throws EvaluatingException;

    @Override
    public T evaluate(T x, T y, T z) throws EvaluatingException {
        return operator(arg.evaluate(x, y, z));
    }
}
