package org.example;

public class Staff {
    private  String name;
    private  int salary;
    public Staff(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("$Salary: "+salary);
    }
}
