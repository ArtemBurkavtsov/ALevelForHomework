package ua.burkavtsov.hw2;

public class Task1 {
    //Цвета
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_WHITE = "\u001B[37m";
    public static final String COLOR_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        //Данные
        double xA = 1, yA = 5;
        double xB = 3, yB = 5;
        double xC = 6, yC = 7;
        double Geron = calculateTriangleArea(xA, yA, xB, yB, xC, yC);
        System.out.println(COLOR_RED + "Данны координаты: " + COLOR_WHITE + "A(1, 5), B(3, 5), C(6, 7)");
        //Формула
        System.out.println(COLOR_YELLOW + "Будем использовать формулу Герона");
        System.out.println(COLOR_GREEN + "Результат: " + COLOR_WHITE + Geron);
    }

    public static double calculateTriangleArea(double xA, double yA, double xB, double yB, double xC, double yC) {
        double side1 = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
        double side2 = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yC - yB, 2));
        double side3 = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yA - yC, 2));

        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}
