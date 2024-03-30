package by.nikita.calculator;

import java.text.MessageFormat;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.util.Objects.requireNonNull;

abstract class AbstractArithmeticExpressionSimplifier implements ArithmeticExpressionSimplifier {

    private final static String LEFT_OPERAND_PATTERN_GROUP_NAME = "left";
    private final static String RIGHT_OPERAND_PATTERN_GROUP_NAME = "right";
    private final static String DECIMAL_TO_GET_RID_OF = ".0";
    private final Pattern expressionPattern;

    public AbstractArithmeticExpressionSimplifier(Pattern expressionPattern) throws NullPointerException, IllegalArgumentException {
        requireNonNull(expressionPattern);
        validateExpressionPatternNamedGroups(expressionPattern);

        this.expressionPattern = expressionPattern;
    }

    @Override
    public final String apply(String expressionString) {
        Matcher expressionMatcher = expressionPattern.matcher(expressionString);

        if (!expressionMatcher.find()) {
            return null;
        }

        double left = parseDouble(expressionMatcher.group(LEFT_OPERAND_PATTERN_GROUP_NAME));
        double right = parseDouble(expressionMatcher.group(RIGHT_OPERAND_PATTERN_GROUP_NAME));

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

    private static void validateExpressionPatternNamedGroups(Pattern expressionPattern) throws IllegalArgumentException {
        Map<String, Integer> namedGroups = expressionPattern.namedGroups();

        Consumer<String> checkPatternContainsNamedGroup = (String groupName) -> {
            if (!namedGroups.containsKey(groupName)) {
                throw new IllegalArgumentException(MessageFormat.format("\"{0}\" named group not found in pattern \"{1}\"", groupName, expressionPattern));
            }
        };

        checkPatternContainsNamedGroup.accept(LEFT_OPERAND_PATTERN_GROUP_NAME);
        checkPatternContainsNamedGroup.accept(RIGHT_OPERAND_PATTERN_GROUP_NAME);
    }
}