package ua.burkavtsov.hw2;
public class Task3 {
    public static void main(String[] args) {
        //Модульные числа
        double num1 = 4.15;
        double num2 = 3.18;
        double num3 = 1.12;
        double MinNum = findMinNum(num1, num2, num3);
        System.out.println("Меньшее по модулю число: " + MinNum);
    }

    public static double findMinNum(double num1, double num2, double num3) {
        double absNum1 = (num1 < 0) ? -num1 : num1;
        double absNum2 = (num2 < 0) ? -num2 : num2;
        double absNum3 = (num3 < 0) ? -num3 : num3;
        return (absNum1 <= absNum2 && absNum1 <= absNum3) ? num1 : (absNum2 <= absNum3) ? num2 : num3;
    }
}