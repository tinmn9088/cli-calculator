package by.nikita.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyExpressionSimplifierTest {

    @Test
    void applyShouldSimplifyExpressionWithTwoOperands() {
        final String expression = " 2 *  2.5 ";
        final String expected = "5";
        MultiplyExpressionSimplifier simplifier = new MultiplyExpressionSimplifier();

        String actual = simplifier.apply(expression);

        assertEquals(expected, actual);
    }
}