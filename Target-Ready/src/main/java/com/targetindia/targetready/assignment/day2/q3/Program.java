package com.targetindia.targetready.assignment.day2.q3;

public class Program {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(),
                        new Circle(4.0),
                        new Circle(2.0, "blue", false),
                        new Rectangle(),
                        new Rectangle(6.0, 8.0),
                        new Rectangle(6.0, 8.0, "green", true),
                        new Square(),
                        new Square(10.0),
                        new Square(5.0, "black", true),
                        new Circle(11.0)
        };
        for (Shape shape : shapes) {
            System.out.printf("Shape: %s\n", shape.toString());
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println("Area: " + circle.getArea());
                System.out.println("Perimeter: " + circle.getPerimeter());
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("Area: " + rectangle.getArea());
                System.out.println("Perimeter: " + rectangle.getPerimeter());
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                System.out.println("Area: " + square.getArea());
                System.out.println("Perimeter: " + square.getPerimeter());
            }
            System.out.println();
        }

    }
}
