package ua.burkavtsov.hw5;

public class Task3 {
    public static void main(String[] args) {
        char[][] naturalArray = {
                {'1', '2'},
                {'3', '4'}
        };
        char[][] transformedArray = transformArray(naturalArray);
        System.out.println("Изначально: ");
        printArray(naturalArray);
        System.out.println("Изменено: ");
        printArray(transformedArray);
    }

    public static char[][] transformArray(char[][] naturalArray) {
        int rows = naturalArray.length;
        int cols = naturalArray[0].length;
        char[][] transformedArray = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transformedArray[j][i] = naturalArray[i][j];
            }
        }
        return transformedArray;
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
