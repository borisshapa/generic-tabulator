package expression.types;

import expression.exceptions.DivisionByZeroException;
import expression.parser.Source;
import expression.parser.SourceException;

import java.math.BigInteger;

public class BigIntegerType implements Type<BigInteger> {

    @Override
    public BigInteger add(BigInteger arg1, BigInteger arg2) {
        return arg1.add(arg2);
    }

    @Override
    public BigInteger subtract(BigInteger arg1, BigInteger arg2) {
        return arg1.subtract(arg2);
    }

    @Override
    public BigInteger multiply(BigInteger arg1, BigInteger arg2) {
        return arg1.multiply(arg2);
    }

    @Override
    public BigInteger divide(BigInteger arg1, BigInteger arg2) throws DivisionByZeroException {
        if (arg2.equals(BigInteger.ZERO)) {
            throw new DivisionByZeroException();
        }
        return arg1.divide(arg2);
    }

    @Override
    public BigInteger neg(BigInteger arg) {
        return arg.negate();
    }

    @Override
    public BigInteger parseNumber(String arg) throws SourceException {
        try {
            return new BigInteger(arg);
        } catch (NumberFormatException e) {
            throw new SourceException(Source.line, Source.posInLine, "Unexpected argument");
        }
    }

    @Override
    public BigInteger abs(BigInteger arg) {
        return arg.abs();
    }

    @Override
    public BigInteger square(BigInteger arg) {
        return arg.multiply(arg);
    }

    @Override
    public BigInteger mod(BigInteger arg1, BigInteger arg2) {
        BigInteger div = arg1.divide(arg2);
        return arg1.subtract(div.multiply(arg2));
    }
}
