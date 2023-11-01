package ua.burkavtsov.hw5;

public class Task1 {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 3;
        int[][] array = new int[rows][cols];
        fillArray(array);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillArray(int[][] array) {
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i % 2 == 0) ? value : -value;
                value++;
            }
        }
    }
}