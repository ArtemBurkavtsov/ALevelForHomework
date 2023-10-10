public class Task2 {
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        int number = 10;
        boolean isEven = isEven(number);

        if (isEven) {
            System.out.println(number + COLOR_GREEN+" - четное число");
        } else {
            System.out.println(number + COLOR_RED +" - нечетное число");
        }
    }

    public static boolean isEven(int number) {
        return (number % 2 == 0) ? true : false;
    }
}

