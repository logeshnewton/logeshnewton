package org.example;

public class interface2 implements interface1{
    @Override
    public void checksound() {
        System.out.println("could you speak loudly");
    }

    public static void main(String args[]){
        interface1 interface1 = new interface2();
        interface1.checksound();
    }
}
