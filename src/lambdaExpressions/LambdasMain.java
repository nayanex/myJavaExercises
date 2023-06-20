package lambdaExpressions;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class LambdasMain {
    /**
     * Returns the number of strings that match a given condition.
     *
     * @param input the strings that should be tested.
     * @param condition the condition that strings should be tested against.
     * @return the number of strings in the input that match the condition.
     */
    public static long countMatchingStrings(List<String> input, Predicate<String> condition) {
        return input.stream().filter(condition).count();
    }

    public static void main(String[] args) {

        List<String> input = List.of("hello", "\t   ", "world", "", "\t", " ", "goodbye", "  ");

        // Anonymous class example - which can be completely replaced by a lambda
        long numberOfWhitespaceStrings1 =
                countMatchingStrings(input, new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.trim().isEmpty();
                    }
                });

        // Lambda Expression example
        long numberOfWhitespaceStrings =
                countMatchingStrings(input, s -> s.trim().isEmpty());

        System.out.println(numberOfWhitespaceStrings + " whitespace strings");
        System.out.println(numberOfWhitespaceStrings1 + " whitespace strings");

        BinaryOperator<Integer> add =
                (Integer a, Integer b) -> { return a + b; };

        System.out.println(add.apply(1, 2));
    }
}
