package solutions.interview;

import solutions.interview.Models.Person;

public class PassByReference {
    public static void ChangeName(Person person) {
        // person.setLastName("Bartha");
        person = new Person("Lenard", "Bartha", 39);
        // person = null;
    }
}
