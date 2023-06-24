package methodReference;

import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // Reference to a static method
        Function<Double, Double> squareRoot = Math::sqrt;
        System.out.println(squareRoot.apply(16.0));  // Output: 4.0

        // Reference to an instance method of a particular object
        String myString = "Hello, World!";

        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply(myString));  // Output: 13

        // Reference to an instance method of an arbitrary object of a particular type
        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("hello"));  // Output: HELLO

        // Reference to a constructor
        Function<Integer, StringBuilder> stringBuilderConstructor = StringBuilder::new;
        StringBuilder sb = stringBuilderConstructor.apply(10);
        System.out.println(sb.capacity());  // Output: 10
    }
}

