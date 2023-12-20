package ua.burkavtsov.hw15.Task2;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class PersonFactory {
    public Person createPerson(String name, int age, String address) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
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