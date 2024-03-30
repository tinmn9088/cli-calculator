package by.nikita.calculator;

import java.util.function.Function;

interface ArithmeticExpressionSimplifier extends Function<String, String> {

    /**
     * @return simplified expression or <i>null</i>
     */
    @Override
    String apply(String expressionString);
}
