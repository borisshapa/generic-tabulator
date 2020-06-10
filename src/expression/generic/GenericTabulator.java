package expression.generic;

import expression.exceptions.EvaluatingException;
import expression.operations.TripleExpression;
import expression.parser.ExpressionParser;
import expression.parser.SourceException;
import expression.types.*;

import java.util.Map;

public class GenericTabulator implements Tabulator {

    private static final Map<String, Type<?>> TYPES = Map.of(
            "i", new CheckedIntegerType(),
            "d", new DoubleType(),
            "bi", new BigIntegerType(),
            "u", new IntegerType(),
            "f", new FloatType(),
            "b", new ByteType()
    );

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
                    } catch (EvaluatingException ignored) { }
                }
            }
        }
        return res;
    }
}