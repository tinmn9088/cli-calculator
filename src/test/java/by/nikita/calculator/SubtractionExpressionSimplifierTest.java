package by.nikita.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionExpressionSimplifierTest {

    @Test
    void applyShouldSimplifyExpressionWithTwoOperands() {
        final String expression = " 2 -  5 ";
        final String expected = "-3";
        SubtractionExpressionSimplifier simplifier = new SubtractionExpressionSimplifier();

        String actual = simplifier.apply(expression);

        assertEquals(expected, actual);
    }
}