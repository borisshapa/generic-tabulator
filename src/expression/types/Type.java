package expression.types;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;
import expression.parser.SourceException;

public interface Type<T> {
    T add(T arg1, T arg2) throws OverflowException;
    T subtract(T arg1, T arg2) throws OverflowException;
    T multiply(T arg1, T arg2) throws OverflowException;
    T divide(T arg1, T arg2) throws DivisionByZeroException, OverflowException;
    T neg(T arg) throws OverflowException;
    T parseNumber(String arg) throws SourceException;
    T abs(T arg) throws OverflowException;
    T square(T arg) throws OverflowException;
    T mod(T arg1, T arg2) throws DivisionByZeroException;
}
