package ua.burkavtsov.hw4;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] array = genRandomArray(1000, 1, 10);
        int primeCount = countPrimeNumbers(array);
        System.out.println("Количество простых чисел в массиве: " + primeCount);
    }
    public static int[] genRandomArray(int size, int min, int max){
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            Random rand= new Random();
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int countPrimeNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }
}
