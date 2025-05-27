package org.example;

public class Abstraction1 extends Abstraction {


    @Override
    void run() {
        System.out.println("if run fast, you will get success");
    }

    public static void main(String args[]){
        Abstraction abstraction=new Abstraction1();
        abstraction.run();
        abstraction.marathon();
    }
}
