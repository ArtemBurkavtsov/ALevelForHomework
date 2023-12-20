package ua.burkavtsov.hw13;

import java.util.List;

class Figure {
    private double area;
    private double perimeter;

    public Figure(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public static void main(String[] args) {
        List<Figure> figures = List.of(
                new Figure(4, 6),
                new Figure(9, 12),
                new Figure(16, 20)
        );

        List<Figure> result = figures.stream()
                .filter(f -> f.getArea() > 2 * f.getPerimeter())
                .toList();

        result.forEach(f -> System.out.println("Area: " + f.getArea() + ", Perimeter: " + f.getPerimeter()));
    }
}