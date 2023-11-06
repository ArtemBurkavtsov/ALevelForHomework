package ua.burkavtsov.hw9;

class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double areaHeron() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double areaSine() {
        double angle1 = Math.acos((side2 * side2 + side3 * side3 - side1 * side1) / (2 * side2 * side3));
        return 0.5 * side2 * side3 * Math.sin(angle1);
    }

    public double areaBaseHeight(double base, double height) {
        return 0.5 * base * height;
    }

    @Override
    public double area() {
        return areaHeron(); // Default to Heron's formula
    }
}

