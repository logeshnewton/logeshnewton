package org.example;

public class Child extends Parent{
    String value = " Hello Child";

    public void print(){
        System.out.println("Child Value: "+value);
        System.out.println("Parent Value: "+ super.value.toUpperCase());
        System.out.println("Parent Value: "+super.value);
    }
}
