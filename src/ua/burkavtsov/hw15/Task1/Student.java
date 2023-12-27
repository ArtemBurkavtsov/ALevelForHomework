package ua.burkavtsov.hw15.Task1;

import java.lang.reflect.Field;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private int examScore;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void passExamSuccessfully() {
        this.examScore = 100;
    }
}

class StudentInfoPrinter {
    public void printStudentInfo(Student student) {
        Class<?> studentClass = student.getClass();
        Field[] fields = studentClass.getDeclaredFields();

        for (Field field : fields) {
            ShowInfo showInfoAnnotation = field.getAnnotation(ShowInfo.class);
            if (showInfoAnnotation != null && showInfoAnnotation.show()) {
                try {
                    field.setAccessible(true);
                    System.out.println(field.getName() + ": " + field.get(student));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

