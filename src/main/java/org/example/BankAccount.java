package org.example;

public class BankAccount {
    private  String Account_UserName;
    private  int Account_Password;
    private  double Balance;
    public BankAccount(String name, int number, double amount){
        this.Account_UserName = name;
        this.Account_Password = number;
        this.Balance = amount;
    }
    public void Deposit(){
        System.out.println("Account_UserName: "+Account_UserName);
        System.out.println("Account_Password: "+Account_Password);
        System.out.println("Balance: "+Balance);
    }
}
