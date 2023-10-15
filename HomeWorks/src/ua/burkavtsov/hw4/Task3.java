package ua.burkavtsov.hw4;

import java.util.Random;

public class Task3 {

    public static void main(String[] args) {
        int[] array = genRandomArray(2000, 1, 100);
        int[] modifiedArray = replaceEvenWithZeros(array);
        for (int num : modifiedArray) {
            System.out.print(num + " ");
        }
    }
    public static int[] genRandomArray(int size, int min, int max){
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            Random rand= new Random();
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }
    public static int[] replaceEvenWithZeros(int[] array){
        int[] modifiedArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            modifiedArray[i] = (array[i] % 2 == 0) ? 0 : array[i];
        }
        return modifiedArray;
    }
}
