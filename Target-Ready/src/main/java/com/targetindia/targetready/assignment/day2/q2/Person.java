package com.targetindia.targetready.assignment.day2.q2;

import lombok.Data;

@Data
public class Person {
    public String name;
    public String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(){
        address = address.trim();
        if(address == null){
            throw new RuntimeException("Invalid address entry");
        }
        this.address = address;
    }
    public String toString(){
        return "Person[name = "+name+", address = " + address;
    }
}
