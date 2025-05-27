package org.example;

public class overload1 {

    public void Employee(String name, int Rollnumber){
        String Staffname=name;
        int number = Rollnumber;
        if(Staffname!=null&& number!=0){
            System.out.println(Staffname +" "+ number+" :"+ "current employee in this company");

        }

    }
    public int Employee(int Rollnumber){
        int number = Rollnumber;
        if(number>0){
            System.out.println("employee working here");
        }
        return number;
    }

    public static void main(String args[]){
        overload1 overload1 = new overload1();
        System.out.println(overload1.Employee(10));
        overload1.Employee("logesh",7);
    }
}
