package expression.types;

import expression.exceptions.DivisionByZeroException;
import expression.parser.Source;
import expression.parser.SourceException;

public class IntegerType implements Type<Integer> {
    @Override
    public Integer add(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }

    @Override
    public Integer subtract(Integer arg1, Integer arg2) {
        return arg1 - arg2;
    }

    @Override
    public Integer multiply(Integer arg1, Integer arg2) {
        return arg1 * arg2;
    }

    @Override
    public Integer divide(Integer arg1, Integer arg2) throws DivisionByZeroException {
        if (arg2 == 0)
            throw new DivisionByZeroException();
        return arg1 / arg2;
    }

    @Override
    public Integer neg(Integer arg) {
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
    public Integer abs(Integer arg) {
        return (arg < 0) ? -arg : arg;
    }

    @Override
    public Integer square(Integer arg) {
        return arg * arg;
    }

    @Override
    public Integer mod(Integer arg1, Integer arg2) {
        return arg1 % arg2;
    }
}
