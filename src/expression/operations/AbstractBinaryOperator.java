package expression.operations;

import expression.exceptions.EvaluatingException;
import expression.types.Type;

/**
 * Binary operator class
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public abstract class AbstractBinaryOperator<T> implements TripleExpression<T> {
    private final TripleExpression<T> arg1, arg2;
    /**
     * The type in which the expression is evaluated
     */
    protected final Type<T> type;

    /**
     * Creates a binary operator
     *
     * @param arg1 left argument
     * @param arg2 right argument
     * @param type type in which the expression is evaluated
     */
    public AbstractBinaryOperator(TripleExpression<T> arg1, TripleExpression<T> arg2, Type<T> type) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.type = type;
    }

    /**
     * The calculation of the binary operation value.
     *
     * @param arg1 left argument
     * @param arg2 right argument
     * @return operation evaluation result
     * @throws EvaluatingException if an error occurred while evaluating the expression.
     */
    protected abstract T operator(T arg1, T arg2) throws EvaluatingException;

    @Override
    public T evaluate(T x, T y, T z) throws EvaluatingException {
        return operator(arg1.evaluate(x, y, z), arg2.evaluate(x, y, z));
    }
}