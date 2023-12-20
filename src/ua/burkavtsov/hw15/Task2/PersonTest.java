package ua.burkavtsov.hw15.Task2;

public class PersonTest {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Person person = personFactory.createPerson("Alice", 25, "123 Main St.");

        personFactory.printFields(person);
    }
}