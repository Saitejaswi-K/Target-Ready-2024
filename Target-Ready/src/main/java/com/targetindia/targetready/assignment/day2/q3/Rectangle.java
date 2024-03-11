package com.targetindia.targetready.assignment.day2.q3;

public class Rectangle extends Shape{
    public double width = 1.0;
    public double length = 1.0;
    public Rectangle(){}
    public Rectangle(double width, double length){
        this.length = length;
        this.width = width;
    }
    public  Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        if(width < 0){
            throw new RuntimeException("Invalid width value");
        }
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        if(length < 0){
            throw new RuntimeException("Invalid length value");
        }
        this.length = length;
    }
    public double getArea(){
        return width * length;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }
    public String toString(){
        return "Rectangle[width = " + width + ", length = " + length +"]" + " subclass of "
                + super.toString();
    }
}
