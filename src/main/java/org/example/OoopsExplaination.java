package org.example;

public class OoopsExplaination {

    public static void main(String[] args){
        //Encapsulation
        Person person = new Person();
        person.setname("Logesh");
        person.setage(18);
        System.out.println("Person age:"+ " "+person.getage());
        System.out.println("Person name:"+ " "+person.getname());

        //Inheritance

        Employee employee = new Employee();
        employee.setDepartment("Information Technology");
        employee.setname("Newton");
        employee.setage(30);
        System.out.println("Employee department:"+ " " + employee.getDepartment());
        System.out.println("Employee second age:"+ " " + employee.getage());
        System.out.println("Employee second name:"+ " " + employee.getname());

        //Polymorphism - Method overloading

        Calculator calculator = new Calculator();
        System.out.println("Addition(int):"+ " "+calculator.add(10, 20));
        System.out.println("Double(double):"+ " "+calculator.add(10.5, 20.5));

        //Polymorphism - Method overriding

        Shape shape = new Shape();
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        System.out.println("\n Shape Drawing");
        shape.draw();
        circle.draw();
        rectangle.draw();


        //Abstraction

        System.out.println(" Animal Sound");
        Animal dog = new Dog();
       /// Animal cat = new Cat();
        dog.makeSound();
        dog.eat();
        //cat.makeSound();
       // cat.eat();







    }

}
