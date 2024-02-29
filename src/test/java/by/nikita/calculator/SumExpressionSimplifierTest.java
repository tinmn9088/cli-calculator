package by.nikita.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumExpressionSimplifierTest {

    @Test
    void applyShouldSimplifyExpressionWithTwoOperands() {
        final String expression = " 2 +  3 ";
        final String expected = "5";
        SumExpressionSimplifier simplifier = new SumExpressionSimplifier();

        String actual = simplifier.apply(expression);

        assertEquals(expected, actual);
    }

    @Test
    void applyShouldSimplifyExpressionWithThreeOperands() {
        final String expression = " 2 +  3 + 3";
        final String expected = "5 + 3";
        SumExpressionSimplifier simplifier = new SumExpressionSimplifier();

        String actual = simplifier.apply(expression);

        assertEquals(expected, actual);
    }
}