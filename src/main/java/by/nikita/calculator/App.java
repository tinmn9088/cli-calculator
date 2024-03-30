package by.nikita.calculator;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {

    private final static Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String[] args) {
        Collection<ArithmeticExpressionSimplifier> simplifiers = List.of(
                new MultiplyExpressionSimplifier(),
                new DivideExpressionSimplifier(),
                new SumExpressionSimplifier(),
                new SubtractionExpressionSimplifier());

        Scanner userInput = new Scanner(System.in);
        String expression;

        do {
            System.out.print("Input >>> ");
            expression = userInput.nextLine();

            try {
                System.out.printf("Answer: %s\n", simplify(expression, simplifiers));
            } catch (IllegalArgumentException ex) {
                System.out.printf("Error: %s\n", ex.getMessage());
            }
        } while (!expression.equals(":q"));
    }

    static String simplify(String expression, Collection<ArithmeticExpressionSimplifier> simplifiers) throws IllegalArgumentException {
        boolean wasSimplified;

        do {
            wasSimplified = false;

            for (ArithmeticExpressionSimplifier simplifier : simplifiers) {
                String simplifiedExpression = simplifier.apply(expression);

                if (simplifiedExpression != null) { // simplifier did some work
                    expression = simplifiedExpression;
                    wasSimplified = true;
                    break;
                }
            }
        } while (wasSimplified);

        if (!NUMBER_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException(String.format("Invalid expression: '%s'", expression));
        }

        return expression;
    }
}
