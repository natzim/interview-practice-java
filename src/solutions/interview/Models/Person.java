package solutions.interview.Models;

public class Person {
    private String FirstName;
    private String LastName;
    private int Age;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Person(String firstName, String lastName, int age) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
    }

    @Override
    public String toString() {
        return "%s, %s".formatted(this.LastName, this.FirstName);
    }
}
