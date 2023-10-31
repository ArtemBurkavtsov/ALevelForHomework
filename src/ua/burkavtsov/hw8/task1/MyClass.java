package ua.burkavtsov.hw8.task1;

public class MyClass {
    private int privateVar1;
    private int privateVar2;
    public MyClass(int var1, int var2) {
        this.privateVar1 = var1;
        this.privateVar2 = var2;
    }
    public void displayValues() {
        System.out.println("Значення privateVar1: " + privateVar1);
    }
    public void displayValues2() {
        System.out.println("Значення privateVar2: " + privateVar2);
    }
    public static void main(String[] args) {
        MyClass myObject = new MyClass(10, 20);
        myObject.displayValues();
        myObject.displayValues2();
    }
}
