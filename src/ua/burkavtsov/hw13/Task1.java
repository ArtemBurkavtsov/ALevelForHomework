package ua.burkavtsov.hw13;

import java.util.List;
import java.util.Optional;

public class Task1 {
    public static void main(String[] args) {
        List<Figure> figures = 150; double difference = 120;

        Figure result = findFigure(figures, difference);
        System.out.println("Знайдена фігура: " + result);
    }

    private static Figure findFigure(List<Figure> figures, double difference) {
        Optional<Figure> result = figures.stream().filter(figure -> figure.calculateArea() > figure.findMinArea() + difference).findFirst();

        return result.orElse(null);
    }
}

interface Figure {
    double calculateArea();

    double findMinArea();
}
