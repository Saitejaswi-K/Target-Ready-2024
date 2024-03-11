package com.targetindia.targetready.assignment.day2.q3;

public class Shape {
    public String color = "red";
    public boolean filled = true;
    public Shape(){}
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        color = color.trim();
        if(color == null){
            throw new RuntimeException("Invalid color");
        }
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public String toString(){
        return "Shape [color: " + color + ", filled: " + filled + "]";
    }
}
