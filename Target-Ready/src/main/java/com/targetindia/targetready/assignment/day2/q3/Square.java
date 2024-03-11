package com.targetindia.targetready.assignment.day2.q3;

public class Square extends Rectangle{
    public double side;
    public Square(){}
    public Square(double side){
        this.side = side;
    }
    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
        this.side = side;
    }
    public double getSide(){
        return side;
    }
    public void setSide(double side){
        if(side < 0){
            throw new RuntimeException("Invalid side value");
        }
        this.side = side;
    }
    public void setWidth(double side){
        if(side < 0){
            throw new RuntimeException("Invalid side value");
        }
        super.width = side;
    }
    public void setLength(double side){
        if(side < 0){
            throw new RuntimeException("Invalid side value");
        }
        super.length = side;
    }
    public String toString(){
        return "Square[side = " + side + "]" + " subclass of " + super.toString();

    }

}
