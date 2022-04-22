package solutions.interview;

import solutions.interview.Models.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExercise {
    public static void LambdaFunctions() {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Sort the list by last name.
        people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        List<Person> sortedPeople = people.stream().sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList());

        // Create a function that prints all elements in the list.
        System.out.println("Printing all people:");
        printConditionally(people, p -> true);

        System.out.println("Print all people with last name beginning with C:");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("Print all people with first name beginning with C:");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));
    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
        for (Person person:people) {
            if (predicate.test(person)) {
                System.out.println(person);
            }
        }
    }
}
