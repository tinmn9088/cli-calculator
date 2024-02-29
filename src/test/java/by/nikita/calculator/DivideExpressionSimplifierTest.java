package by.nikita.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideExpressionSimplifierTest {

    @Test
    void applyShouldSimplifyExpressionWithTwoOperands() {
        final String expression = " 8 /  2 ";
        final String expected = "4";
        DivideExpressionSimplifier simplifier = new DivideExpressionSimplifier();

        String actual = simplifier.apply(expression);

        assertEquals(expected, actual);
    }
}