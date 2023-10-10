package ua.burkavtsov.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи что-то: ");
        String input = scanner.nextLine();

        String stringWithoutSpace = removeSpaces(input);
        System.out.println("Строка без пробелов: "+ stringWithoutSpace);
        boolean isPalindrome = isPalindrome(stringWithoutSpace);

        if(isPalindrome){
            System.out.println("Строка перевернута");
        }else{
            System.out.println("Строка не перевернута");
        }
    }

    public static String removeSpaces(String input){
        return input.replaceAll(" ", "");
    }

    public static boolean isPalindrome(String input){
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }
}
