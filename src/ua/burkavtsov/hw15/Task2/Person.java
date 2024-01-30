package ua.burkavtsov.hw15.Task2;

import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class PersonFactory {

    public static Person createPerson(String name, int age, String address)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Constructor<Person> constructor = Person.class.getConstructor(String.class, int.class, String.class);
        Person person = constructor.newInstance(name, age, address);

        return person;
    }

    public void printFields(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}