package setExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExercise {
    public static void main(String[] args){
        List<String> numbers = new ArrayList<String>();

        numbers.add("33-333-333-3");
        numbers.add("33-333-333-3");
        numbers.add("33-333-333-3");
        numbers.add("666-999");

        Set<String> uniqueNumbers = new HashSet<String>(numbers);

        for (String un:uniqueNumbers) {
            System.out.println(un);
        }
    }
}
