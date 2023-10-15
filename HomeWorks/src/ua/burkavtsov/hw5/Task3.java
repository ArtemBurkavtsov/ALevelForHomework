package ua.burkavtsov.hw5;

public class Task3 {
    public static void main(String[] args) {
        char[][] naturalArray = {
                {'1', '2'},
                {'3', '4'}
        };
        char[] transformArray = transformedArray(naturalArray);
        System.out.println("Изначально: ");
        printArray(naturalArray);
        System.out.println("Изменено: ");
        System.out.println(transformArray);
    }

    public static char[] transformedArray(char[][] naturalArray) {
        int rows = naturalArray.length;
        int cols = naturalArray[0].length;
        char[] transformArray = new char[rows * cols];
        int index = 0;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < rows; i++) {
                transformArray[index] = naturalArray[i][j];
                index++;
            }
        }
        return transformArray;
    }

    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
