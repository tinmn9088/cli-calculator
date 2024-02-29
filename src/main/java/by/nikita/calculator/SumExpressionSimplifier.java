package by.nikita.calculator;

import java.util.regex.Pattern;

final class SumExpressionSimplifier extends AbstractArithmeticExpressionSimplifier {

    private final static Pattern EXPRESSION_PATTERN = Pattern.compile("(\\d+)\\s*\\+\\s*(\\d+)");

    public SumExpressionSimplifier() throws NullPointerException, IllegalArgumentException {
        super(EXPRESSION_PATTERN);
    }

    @Override
    public double calculate(double left, double right) {
        return left + right;
    }
}
