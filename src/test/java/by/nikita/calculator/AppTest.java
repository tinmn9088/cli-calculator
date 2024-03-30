package by.nikita.calculator;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private final Collection<ArithmeticExpressionSimplifier> simplifiers = List.of(new SumExpressionSimplifier(), new SubtractionExpressionSimplifier(), new MultiplyExpressionSimplifier(), new DivideExpressionSimplifier());

    @Test
    void simplifyShouldSolveSumSumExpression() {
        String expression = " 4 + 2 + 2";
        String expected = "8";

        String actual = App.simplify(expression, simplifiers);

        assertEquals(expected, actual);
    }

    @Test
    void simplifyShouldSolveSumSubtractExpression() {
        String expression = " 4  + 2 - 3 ";
        String expected = "3";

        String actual = App.simplify(expression, simplifiers);

        assertEquals(expected, actual);
    }

    @Test
    void simplifyShouldSolveSumSumSubtractExpression() {
        String expression = " 1  + 1 + 1 - 6.5 ";
        String expected = "-3.5";

        String actual = App.simplify(expression, simplifiers);

        assertEquals(expected, actual);
    }

    @Test
    void simplifyShouldSolveMultiplyDivideExpression() {
        String expression = " 6 * 1.5 / 3 ";
        String expected = "3";

        String actual = App.simplify(expression, simplifiers);

        assertEquals(expected, actual);
    }
}