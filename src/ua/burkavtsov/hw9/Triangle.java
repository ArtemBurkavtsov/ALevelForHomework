package ua.burkavtsov.hw9;

public class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
return side1 + side2 + side3;
}

    public double calculateAreaUsingHeron() throws InvalidParameterException, NonExistentTriangleException {
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

    public double area(double angle1) throws InvalidParameterException {
        if (side2 <= 0 || side3 <= 0 || angle1 <= 0) {
            throw new InvalidParameterException("Side lengths and angle must be positive values.");
        }

        return 0.5 * side2 * side3 * Math.sin(Math.toRadians(angle1));
    }

    @Override
    public double area(double angle1) throws InvalidParameterException {
        if (side1 <= 0 || side2 <= 0 || angle1 <= 0) {
            throw new InvalidParameterException("Side lengths and angle must be positive values.");
        }

        return 0.5 * side1 * side2 * Math.sin(Math.toRadians(angle1));
    }
}