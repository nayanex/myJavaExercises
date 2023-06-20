package lambdaExpressions;

@FunctionalInterface
public interface BinaryOperation {
    abstract int apply(int a, int b);
}
