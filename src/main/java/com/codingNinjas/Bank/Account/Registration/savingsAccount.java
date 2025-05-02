package com.codingNinjas.Bank.Account.Registration;

public class savingsAccount implements Account{
    double amount = 0;

    public void init(){
        System.out.println("Saving Account has been created I'm the init() method");
    }

    @Override
    public String getAccountType() {
        return "Saving Account";
    }

    @Override
    public void addBalance(double balance) {
        this.amount += balance;
    }

    @Override
    public double getBalance() {
        return this.amount;
    }
}
