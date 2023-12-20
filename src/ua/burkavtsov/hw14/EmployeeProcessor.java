package ua.burkavtsov.hw14;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeProcessor {
    public static void main(String[] args) {
        List<Employee> employees = readEmployeesFromFile("input.txt");

        printEmployeesWithFirstNameStartingWithA(employees);

        sortEmployeesByNameAndSalary(employees);

        printEmployeesWithMinSalary(employees);

        int totalSalary = calculateTotalSalary(employees);
        System.out.println("Total Salary: " + totalSalary);

        int salaryDifference = calculateSalaryDifferenceBetweenOldestAndYoungest(employees);
        System.out.println("Salary Difference between Oldest and Youngest Employee: " + salaryDifference);

        writeResultsToFile("output.txt", employees, totalSalary, salaryDifference);
    }

    private static List<Employee> readEmployeesFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(":");
                String attributeName = parts[0].trim();
                String attributeValue = parts[1].trim();

                switch (attributeName) {
                    case "name":
                        String name = attributeValue.substring(1, attributeValue.length() - 1); // Remove quotes
                        String secondName = reader.readLine().split(":")[1].trim().substring(1, attributeValue.length() - 1); // Remove quotes
                        int salary = Integer.parseInt(reader.readLine().split(":")[1].trim());
                        int age = Integer.parseInt(reader.readLine().split(":")[1].trim());

                        Employee employee = new Employee(name, secondName, salary, age);
                        employees.add(employee);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private static void printEmployeesWithFirstNameStartingWithA(List<Employee> employees) {
        System.out.println("Employees whose firstName starts with 'A':");
        for (Employee employee : employees) {
            if (employee.name.startsWith("A")) {
                System.out.println(employee.name + " " + employee.secondName);
                break;
            }
        }
        System.out.println();
    }

    private static void sortEmployeesByNameAndSalary(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
    }

    private static void printEmployeesWithMinSalary(List<Employee> employees) {
        int minSalary = Integer.MAX_VALUE;
        System.out.println("Employees with min salary:");
        for (Employee employee : employees) {
            if (employee.salary < minSalary) {
                minSalary = employee.salary;
            }
        }

        for (Employee employee : employees) {
            if (employee.salary == minSalary) {
                System.out.println(employee.name + " " + employee.secondName);
            }
        }
        System.out.println();
    }

    private static int calculateTotalSalary(List<Employee> employees) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.salary;
        }
        return totalSalary;
    }

    private static int calculateSalaryDifferenceBetweenOldestAndYoungest(List<Employee> employees) {
        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;

        for (Employee employee : employees) {
            if (employee.age < minAge) {
                minAge = employee.age;
            }

            if (employee.age > maxAge) {
                maxAge = employee.age;
            }
        }

        Employee youngestEmployee = null;
        Employee oldestEmployee = null;

        for (Employee employee : employees) {
            if (employee.age == minAge) {
                youngestEmployee = employee;
            }

            if (employee.age == maxAge) {
                oldestEmployee = employee;
            }
        }

        return oldestEmployee.salary - youngestEmployee.salary;
    }

    private static void writeResultsToFile(String fileName, List<Employee> employees, int totalSalary, int salaryDifference) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Employees whose firstName starts with 'A':\n");
            for (Employee employee : employees) {
                if (employee.name.startsWith("A")) {
                    writer.write(employee.name + " " + employee.secondName + "\n");
                    break; // Write only the first match
                }
            }
            writer.write("\n");

            writer.write("Sorted Employees based on firstName, for same firstName sort by salary:\n");
            for (Employee employee : employees) {
                writer.write(employee.name + " " + employee.secondName + " - " + employee.salary + "\n");
            }
            writer.write("\n");

            writer.write("Employees with min salary:\n");
            for (Employee employee : employees) {
                if (employee.salary == totalSalary) {
                    writer.write(employee.name + " " + employee.secondName + "\n");
                }
            }
            writer.write("\n");

            writer.write("Total Salary: " + totalSalary + "\n\n");

            writer.write("Salary Difference between Oldest and Youngest Employee: " + salaryDifference + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
