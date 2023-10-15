package ua.burkavtsov.hw4;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = genRandomArray(400, 1, 10);

        double averageArithmetic = calculateAverageArithmetic(array);
        double averageGeometric = calculateAverageGeometric(array);

        System.out.println("Среднее арифметическое: " + averageArithmetic);
        System.out.println("Среднее геометрическое: " + averageGeometric);
    }
    public static int[] genRandomArray(int size, int min, int max){
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            Random rand= new Random();
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }
    public static double calculateAverageArithmetic(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    public static double calculateAverageGeometric(int[] array) {
        double product = 1.0;
        for (int num : array) {
            product *= num;
        }
        return Math.pow(product, 1.0 / array.length);
    }
}
