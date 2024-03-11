package com.targetindia.targetready.assignment.day2.q2;

public class Student extends Person{
    public String program;
    public int year;
    public double fee;
    public Student(String name, String program, String address, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    public String getProgram(){
        return program;
    }
    public void setYear(int year){
        if(year < 1){
            throw new RuntimeException("Invalid year entry.");
        }
        this.year = year;
    }
    public double getFee(){
        return fee;
    }
    public void setFee(){
        this.fee = fee;
    }
    public String toString(){
        return "Student[Person[name = " + name + ", address = " + address +
                "], program = " + program + ", year = " + year + ", fee = " +
                fee + "]";
    }
}
