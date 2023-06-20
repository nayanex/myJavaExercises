package lambdaExpressions;

import java.util.function.BinaryOperator;

public final class Main {
    public static void main(String[] args){
        BinaryOperation add = (a, b) -> a + b;
        assert 5 == add.apply(2,3);

        BinaryOperator<Integer> add_default = (a, b) -> a + b;
        assert 5 == add_default.apply(2, 3);
    }
}
