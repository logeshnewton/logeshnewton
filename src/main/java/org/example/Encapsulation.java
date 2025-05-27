package org.example;

public class Encapsulation {

    private String name;
    private int name1;

    public void setName(String names){
        this.name=names;
    }
    public String getName(){
        return name;
    }

    public void setName1(int name){
        this.name1=name;
    }
    public int getName1(){
        return name1;
    }

    public static void main(String args[]){

        Encapsulation encapsulation = new Encapsulation();
        encapsulation.setName("logesh");
        encapsulation.setName1(10);
        System.out.println(encapsulation.getName());
        System.out.println(encapsulation.getName1());
    }
}
