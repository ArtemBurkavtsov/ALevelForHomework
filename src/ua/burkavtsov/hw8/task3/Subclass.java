package ua.burkavtsov.hw8.task3;

public class Subclass extends NewClass {
    public Subclass(int var1, int var2) {
        super(var1, var2);
    }

    public void newMethod() {
        System.out.println("Subclass: New method");
    }

    public final void finalMethod() {
        System.out.println("Subclass: Final method");
    }
}
