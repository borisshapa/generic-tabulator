package expression.types;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;
import expression.parser.Source;
import expression.parser.SourceException;

/**
 * integer type with overflow check
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class CheckedIntegerType implements Type<Integer> {

    @Override
    public Integer add(final Integer arg1, final Integer arg2) throws OverflowException {
        if (arg1 > 0 && Integer.MAX_VALUE - arg1 < arg2 || arg1 < 0 && Integer.MIN_VALUE - arg1 > arg2) {
            throw new OverflowException();
        }
        return arg1 + arg2;
    }

    @Override
    public Integer subtract(final Integer arg1, final Integer arg2) throws OverflowException {
        if (arg1 >= 0 && arg2 < 0 && arg1 - Integer.MAX_VALUE > arg2
                || arg1 <= 0 && arg2 > 0 && Integer.MIN_VALUE - arg1 > -arg2) {
            throw new OverflowException();
        }
        return arg1 - arg2;
    }

    @Override
    public Integer multiply(final Integer arg1, final Integer arg2) throws OverflowException {
        if (arg1 > 0 && arg2 > 0 && Integer.MAX_VALUE / arg1 < arg2
                || arg1 > 0 && arg2 < 0 && Integer.MIN_VALUE / arg1 > arg2
                || arg1 < 0 && arg2 > 0 && Integer.MIN_VALUE / arg2 > arg1
                || arg1 < 0 && arg2 < 0 && Integer.MAX_VALUE / arg1 > arg2) {
            throw new OverflowException();
        }
        return arg1 * arg2;
    }

    @Override
    public Integer divide(final Integer arg1, final Integer arg2) throws DivisionByZeroException, OverflowException {
        if (arg2 == 0) {
            throw new DivisionByZeroException();
        }
        if (arg1 == Integer.MIN_VALUE && arg2 == -1)
            throw new OverflowException();
        return arg1 / arg2;
    }

    @Override
    public Integer neg(Integer arg) throws OverflowException {
        if (arg == Integer.MIN_VALUE)
            throw new OverflowException();
        return -arg;
    }

    @Override
    public Integer parseNumber(String arg) throws SourceException {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new SourceException(Source.line, Source.posInLine, "Unexpected argument");
        }
    }

    @Override
    public Integer abs(Integer arg) throws OverflowException {
        if (arg == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return (arg < 0) ? -arg : arg;
    }

    @Override
    public Integer square(Integer arg) throws OverflowException {
        if (arg > 46340) {
            throw new OverflowException();
        }
        return arg * arg;
    }

    @Override
    public Integer mod(Integer arg1, Integer arg2) throws DivisionByZeroException {
        if (arg2 == 0) {
            throw new DivisionByZeroException();
        }
        return arg1 % arg2;
    }
}
