package mapsExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args){
        Map<String, Person> mapOfPeople = new HashMap<String, Person>();

        ArrayList<Person> people = new ArrayList<Person>();

        people.add(new Person("Jeff Fucking Nuts Bezos","jeff@email.com"));
        people.add(new Person("Keri Hilson","keri@email.com"));
        people.add(new Person("Justin Timberlake","justin@email.com"));

        for (Person person: people) {
            mapOfPeople.put(person.getEmail(), person);
        }

        System.out.println(mapOfPeople.get("jeff@email.com"));

        for (String email : mapOfPeople.keySet()) {
            System.out.println(email);
        }

        for (Person person : mapOfPeople.values()) {
            System.out.println(person);
        }

        System.out.println("Get Mike: " + mapOfPeople.get("mike@email.com"));
        System.out.println("Get Jeff: " + mapOfPeople.get("jeff@email.com"));
        System.out.println("Contains Mike: " + mapOfPeople.containsKey("mike@email.com"));
        System.out.println("Contains Jeff: " + mapOfPeople.containsKey("jeff@email.com"));
    }

    private static void addToMap(Map<String, Person> map, Person person) {
        map.put(person.getEmail(), person);
    }
}
