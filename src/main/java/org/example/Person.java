package org.example;

public class Person {
    private String name;
    private int age;

    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }
    public int getage(){
        return age;
    }
    public void setage(int age){
        if(age > 0){
            this.age = age;
        }else{
            System.out.println("Invalid age");
        }

    }
}
