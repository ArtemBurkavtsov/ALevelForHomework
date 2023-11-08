package ua.burkavtsov.hw9;

public class Main {
    public static Figure findLargestAreaFigure(Figure[] figures) {
        Figure largestFigure = null;
        double largestArea = 0.0;

        for (Figure figure : figures) {
            double area = figure.area();
            if (area > largestArea) {
                largestArea = area;
                largestFigure = figure;
            }
        }

        return largestFigure;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(4);
        Triangle triangle = new Triangle(3, 4, 5);

        Figure[] figures = {circle, square, triangle};
        Figure largestAreaFigure = findLargestAreaFigure(figures);

        if (largestAreaFigure != null) {
            System.out.println("The figure with the largest area is a " + largestAreaFigure.getClass().getSimpleName() +
                    " with an area of " + largestAreaFigure.area());
        } else {
            System.out.println("No figure found");
        }
    }


}
