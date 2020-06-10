package expression.types;

import expression.exceptions.DivisionByZeroException;
import expression.parser.Source;
import expression.parser.SourceException;

/**
 * Byte type
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class ByteType implements Type<Byte> {
    @Override
    public Byte add(Byte arg1, Byte arg2) {
        return ((byte) (arg1 + arg2));
    }

    @Override
    public Byte subtract(Byte arg1, Byte arg2) {
        return ((byte) (arg1 - arg2));
    }

    @Override
    public Byte multiply(Byte arg1, Byte arg2) {
        return ((byte) (arg1 * arg2));
    }

    @Override
    public Byte divide(Byte arg1, Byte arg2) throws DivisionByZeroException {
        if (arg2 == 0)
            throw new DivisionByZeroException();
        return ((byte) (arg1 / arg2));
    }

    @Override
    public Byte neg(Byte arg) {
        return (byte) (-arg);
    }

    @Override
    public Byte parseNumber(String arg) throws SourceException {
        try {
            return (byte) Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new SourceException(Source.line, Source.posInLine, "Unexpected argument");
        }
    }

    @Override
    public Byte abs(Byte arg) {
        return (arg < 0) ? (byte) (-arg) : arg;
    }

    @Override
    public Byte square(Byte arg) {
        return (byte) (arg * arg);
    }

    @Override
    public Byte mod(Byte arg1, Byte arg2) {
        return (byte) (arg1 % arg2);
    }
}
