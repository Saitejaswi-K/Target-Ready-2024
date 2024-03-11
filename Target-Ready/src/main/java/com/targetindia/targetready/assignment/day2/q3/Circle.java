package com.targetindia.targetready.assignment.day2.q3;

public class Circle extends Shape{
    public double radius = 1.0;
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        if(radius < 0){
            throw new RuntimeException("Invalid radius. Enter radius value > 0");
        }
        this.radius = radius;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }
    public double getPerimeter(){
        return 6.28*radius;
    }
    @Override
    public String toString(){
        return "Circle[radius = " + radius + "]" + " subclass of " + super.toString();
    }

}
