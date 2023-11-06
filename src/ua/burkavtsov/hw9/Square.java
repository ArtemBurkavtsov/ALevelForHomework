package ua.burkavtsov.hw9;

class Square extends Figure {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double perimeter() {
        return 4 * sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }
}
