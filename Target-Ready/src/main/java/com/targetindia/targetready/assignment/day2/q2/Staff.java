package com.targetindia.targetready.assignment.day2.q2;

public class Staff extends Person{
    public String school;
    public double pay;
    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
    public String getSchool(){
        return school;
    }
    public void setSchool(String school){
        school = school.trim();
        if(school == null){
            throw new RuntimeException("Enter valid school name");
        }
        this.school = school;
    }
    public String toString(){
        return "Staff[Person[name = " + name + ", address = " + address + "], school = "
                + school + ", pay = " + pay + "]";
    }
}
