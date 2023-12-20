package ua.burkavtsov.hw12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            List<Square> squares = new ArrayList<>();
            squares.add(new Square(4));
            squares.add(new Square(2));
            squares.add(new Square(5));
            Collections.sort(squares, Comparator.comparingDouble(Square::getArea));
            System.out.println("Сортування за площею:");
            squares.forEach(square -> System.out.println("Площа: " + square.getArea() + ", Периметр: " + square.getPerimeter()));

            Collections.sort(squares, Comparator.comparingDouble(Square::getPerimeter));
            System.out.println("\nСортування за периметром:");
            squares.forEach(square -> System.out.println("Площа: " + square.getArea() + ", Периметр: " + square.getPerimeter()));
        }
}
