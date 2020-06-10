package expression.types;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;
import expression.parser.SourceException;

/**
 * The type in which expressions are evaluated. Interface for defining type operations.
 *
 * @param <T> type of argument
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public interface Type<T> {
    /**
     * Addition operation.
     *
     * @param arg1 first term
     * @param arg2 second term
     * @return summation result
     * @throws OverflowException if the result does not fit into restrictions for a particular type
     */
    T add(T arg1, T arg2) throws OverflowException;

    /**
     * Subtraction operation
     *
     * @param arg1 minuend
     * @param arg2 subtrahend
     * @return subtraction result
     * @throws OverflowException if the result does not fit into restrictions for a particular type
     */
    T subtract(T arg1, T arg2) throws OverflowException;

    /**
     * Multiplication operation
     *
     * @param arg1 first multiplier
     * @param arg2 second multiplier
     * @return multiplication result
     * @throws OverflowException if the result does not fit into restrictions for a particular type
     */
    T multiply(T arg1, T arg2) throws OverflowException;

    /**
     * Division operation
     *
     * @param arg1 dividend
     * @param arg2 divider
     * @return division result
     * @throws DivisionByZeroException if the divider is 0
     * @throws OverflowException       if the result does not fit into restrictions for a particular type
     */
    T divide(T arg1, T arg2) throws DivisionByZeroException, OverflowException;

    /**
     * Negation operation
     *
     * @param arg argument
     * @return the number with the opposite sign.
     * @throws OverflowException if the result does not fit into restrictions for a particular type
     */
    T neg(T arg) throws OverflowException;

    /**
     * Parses number by {@link String}
     *
     * @param arg {@link String} argument
     * @return <var>T</var> type number
     * @throws SourceException if an error occurred while parsing the line
     */
    T parseNumber(String arg) throws SourceException;

    /**
     * Module operation
     *
     * @param arg argument
     * @return a positive sign expression.
     * @throws OverflowException if the result does not fit into restrictions for a particular type
     *                           (for example, taking a module from a {@link Integer#MIN_VALUE})
     */
    T abs(T arg) throws OverflowException;

    /**
     * Squaring operation.
     *
     * @param arg argument
     * @return a squared number
     * @throws OverflowException if the result does not fit into restrictions for a particular type
     */
    T square(T arg) throws OverflowException;

    /**
     * Reminder operation
     *
     * @param arg1 divided
     * @param arg2 divider
     * @return The remainder of dividing <var>arg1</var> by <var>arg2</var>
     * @throws DivisionByZeroException if the divider is 0
     */
    T mod(T arg1, T arg2) throws DivisionByZeroException;
}
