package org.example;

public class Manager extends Staff {

    private  String Department;
    public Manager(String name, int salary, String Department){
        super(name, salary);
        this.Department = Department;

    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Department: "+Department);
    }
}
