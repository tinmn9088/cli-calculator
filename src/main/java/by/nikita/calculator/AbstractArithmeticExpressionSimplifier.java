package by.nikita.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.util.Objects.requireNonNull;

abstract class AbstractArithmeticExpressionSimplifier implements ArithmeticExpressionSimplifier {

    private final static String DECIMAL_TO_GET_RID_OF = ".0";

    private final Pattern expressionPattern;

    public AbstractArithmeticExpressionSimplifier(Pattern expressionPattern) throws NullPointerException {
        requireNonNull(expressionPattern);
        this.expressionPattern = expressionPattern;
    }

    /**
     * @return Simplified expression or null.
     */
    @Override
    public final String apply(String expressionString) {
        Matcher expressionMatcher = expressionPattern.matcher(expressionString);

        if (!expressionMatcher.find()) {
            return null;
        }

        double left = parseDouble(expressionMatcher.group(1));
        double right = parseDouble(expressionMatcher.group(2));

        double result = calculate(left, right);

        return expressionMatcher.replaceFirst(formatResult(result)).trim();
    }

    public abstract double calculate(double left, double right);

    private String formatResult(double result) {
        String resultString = Double.toString(result);

        if (resultString.endsWith(DECIMAL_TO_GET_RID_OF)) {
            resultString = resultString.substring(0, resultString.length() - DECIMAL_TO_GET_RID_OF.length());
        }

        return resultString;
    }
}