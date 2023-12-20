package ua.burkavtsov.hw9;

public abstract class Figure {
    public abstract double perimeter();

    public abstract double area() throws InvalidParameterException, NonExistentTriangleException;

}

class InvalidParameterException extends Exception {
    public InvalidParameterException(String message) {
        super(message);
    }
}

class NonExistentTriangleException extends Exception {
    public NonExistentTriangleException(String message) {
        super(message);
    }
}
