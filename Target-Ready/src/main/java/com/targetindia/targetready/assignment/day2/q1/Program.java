package com.targetindia.targetready.assignment.day2.q1;

public class Program {
    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for (int i=0; i< circles.length; i++) {
            double circleArea = circles[i].getArea();
            double cylinderVolume = ((Cylinder) circles[i]).getVolume();
            System.out.printf("Circle%d area: %.2f%%\n", i+1, circleArea);
            System.out.printf("Cylinder%d volume: %.2f%%\n\n", i+1, cylinderVolume);
        }

    }



}
