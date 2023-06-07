package collectionExample;

import java.util.ArrayList;
import java.util.Collections;

public class SortingExample {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Este Haim");
        names.add("Danielle Haim");
        names.add("Alana Haim");
        names.add("Dash Hutton");

        // Before  Sorting
        for (String name : names) {
            System.out.println(name);
        }

        Collections.sort(names);

        // After  Sorting
        for (String name : names) {
            System.out.println(name);
        }

    }
}
