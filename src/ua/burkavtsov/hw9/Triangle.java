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

    public double areaHeron() throws InvalidParameterException, NonExistentTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new InvalidParameterException("Side lengths must be positive values.");
        }

        double s = perimeter() / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        if (Double.isNaN(area) || Double.isInfinite(area)) {
            throw new NonExistentTriangleException("The triangle with given side lengths does not exist.");
        }

        return area;
    }

    public double area(double side2, double side3, double angle1) throws InvalidParameterException {
        if (side2 <= 0 || side3 <= 0) {
            throw new InvalidParameterException("Side lengths must be positive values.");
        }

        return 0.5 * side2 * side3 * Math.sin(angle1);
    }

    public double area(double base, double height) throws InvalidParameterException {
        if (base <= 0 || height <= 0) {
            throw new InvalidParameterException("Base and height must be positive values.");
        }

        return 0.5 * base * height;
    }

    @Override
    public double area() throws InvalidParameterException, NonExistentTriangleException {
        return areaHeron(); // Default to Heron's formula
    }
}