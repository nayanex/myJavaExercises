package lambdaExpressions;

public final class Calculator {
    public int calculate(int a, char operator, int b) {
        int result = 0;
        switch (operator) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
            default -> System.out.println("Invalid operator");
        }
        return result;
    }

}
