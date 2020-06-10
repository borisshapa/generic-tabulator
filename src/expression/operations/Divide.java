package expression.operations;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;
import expression.types.Type;

/**
 * Division operation.
 *
 * @param <T> arguments type
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class Divide<T> extends AbstractBinaryOperator<T> {
    /**
     * Creates a division operation.
     *
     * @param a    dividend
     * @param b    divider
     * @param type type in which to calculate the value
     */
    public Divide(TripleExpression<T> a, TripleExpression<T> b, Type<T> type) {
        super(a, b, type);
    }

    @Override
    protected T operator(T a, T b) throws DivisionByZeroException, OverflowException {
        return type.divide(a, b);
    }
}