package by.nikita.calculator;

import java.util.regex.Pattern;

final class MultiplyExpressionSimplifier extends AbstractArithmeticExpressionSimplifier {

    private final static Pattern EXPRESSION_PATTERN = Pattern.compile("(?<left>-?\\d+(\\.\\d+)?)\\s*\\*\\s*(?<right>\\d+(\\.\\d+)?)");

    public MultiplyExpressionSimplifier() {
        super(EXPRESSION_PATTERN);
    }

    @Override
    public double calculate(double left, double right) {
        return left * right;
    }
}
