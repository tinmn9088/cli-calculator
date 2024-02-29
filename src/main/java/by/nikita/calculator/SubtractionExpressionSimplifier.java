package by.nikita.calculator;

import java.util.regex.Pattern;

final class SubtractionExpressionSimplifier extends AbstractArithmeticExpressionSimplifier {

    private final static Pattern EXPRESSION_PATTERN = Pattern.compile("(\\d+)\\s*-\\s*(\\d+)");

    public SubtractionExpressionSimplifier() throws NullPointerException, IllegalArgumentException {
        super(EXPRESSION_PATTERN);
    }

    @Override
    public double calculate(double left, double right) {
        return left - right;
    }
}