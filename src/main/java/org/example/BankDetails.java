package org.example;

public class BankDetails {

    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount("Logesh",98899821,190.90);
        BankAccount bankAccount1 = new BankAccount("Newton",89895829,290.50);

        System.out.println("Account 1 details");
        bankAccount.Deposit();
        System.out.println("Account 2 details");
        bankAccount1.Deposit();
    }

}
