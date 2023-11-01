package ua.burkavtsov.hw5;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2};
        boolean sort = sortDescending(array);
        System.out.println("Массив упорядочен по убыванию: " + sort);
    }

    public static boolean sortDescending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
