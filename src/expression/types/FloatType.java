package expression.types;

import expression.parser.Source;
import expression.parser.SourceException;

public class FloatType implements Type<Float> {
    @Override
    public Float add(Float arg1, Float arg2) {
        return arg1 + arg2;
    }

    @Override
    public Float subtract(Float arg1, Float arg2) {
        return arg1 - arg2;
    }

    @Override
    public Float multiply(Float arg1, Float arg2) {
        return arg1 * arg2;
    }

    @Override
    public Float divide(Float arg1, Float arg2) {
        return arg1 / arg2;
    }

    @Override
    public Float neg(Float arg) {
        return -arg;
    }

    @Override
    public Float parseNumber(String arg) throws SourceException {
        try {
            return Float.parseFloat(arg);
        } catch (NumberFormatException e) {
            throw new SourceException(Source.line, Source.posInLine, "Unexpected argument");
        }
    }

    @Override
    public Float abs(Float arg) {
        return (arg < 0) ? -arg : arg;
    }

    @Override
    public Float square(Float arg) {
        return arg * arg;
    }

    @Override
    public Float mod(Float arg1, Float arg2) {
        return arg1 % arg2;
    }
}
