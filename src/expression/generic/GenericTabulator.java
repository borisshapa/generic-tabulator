package expression.generic;

import expression.exceptions.EvaluatingException;
import expression.operations.TripleExpression;
import expression.parser.ExpressionParser;
import expression.parser.SourceException;
import expression.types.*;

import java.util.Map;

/**
 * A class for constructing a matrix of expression values.
 *
 * @author <a href="https://teleg.run/borisshapa">Boris Shaposhnikov</a>
 */
public class GenericTabulator implements Tabulator {

    private static final Map<String, Type<?>> TYPES = Map.of(
            "i", new CheckedIntegerType(),
            "d", new DoubleType(),
            "bi", new BigIntegerType(),
            "u", new IntegerType(),
            "f", new FloatType(),
            "b", new ByteType()
    );

    /**
     * Constructs a matrix of values of a certain type of expression in a specified range.
     *
     * @param mode       режим вычислений:
     *                   <ul>
     *                    <li><var>i</var> – calculations in int with checking for overflow;</li>
     *                    <li><var>d</var> – calculations in double without checking for overflow;</li>
     *                    <li><var>bi</var> – calculations in BigInteger.</li>
     *                    <li><var>u</var> – calculations in int without checking for overflow;</li>
     *                    <li><var>f</var> – calculations in float without checking for overflow;</li>
     *                    <li><var>b</var> – calculations in byte without checking for overflow.</li>
     *                   </ul>
     * @param expression expression to build the table for
     * @param x1         lower bound for x variable
     * @param x2         upper bound for x variable
     * @param y1         lower bound for y variable
     * @param y2         upper bound for y variable
     * @param z1         lower bound for z variable
     * @param z2         upper bound for z variable
     * @return matrix in which the (i, j, k) element contains the value of the expression
     * for x = x1 + i, y = y1 + j, z = z1 + k. If the value is not defined (for example, due to overflow),
     * then the corresponding element is null
     * @throws SourceException if it was not possible to parse the expression or range boundaries
     */
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws SourceException {
        return makeTable(TYPES.get(mode), expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] makeTable(Type<T> type, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws SourceException {
        Object[][][] res = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        TripleExpression<T> exp = new ExpressionParser<>(type).parse(expression);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        res[i - x1][j - y1][k - z1] = exp.evaluate(type.parseNumber(Integer.toString(i)), type.parseNumber(Integer.toString(j)), type.parseNumber(Integer.toString(k)));
                    } catch (EvaluatingException ignored) {
                    }
                }
            }
        }
        return res;
    }
}