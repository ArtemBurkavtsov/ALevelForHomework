package ua.burkavtsov.hw14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    String name;
    String secondName;
    int salary;
    int age;

    public Employee(String name, String secondName, int salary, int age) {
        this.name = name;
        this.secondName = secondName;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
