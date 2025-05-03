package com.codingNinjas.Bank.Account.Registration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("currentAccount")
@Scope("prototype")
public class currentAccount implements Account{
    double amount = 0;

    @PostConstruct
    public void init(){
        System.out.println("Current Account has been created I'm the init() method");
    }

    @Override
    public String getAccountType() {
        return "Current Account";
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
