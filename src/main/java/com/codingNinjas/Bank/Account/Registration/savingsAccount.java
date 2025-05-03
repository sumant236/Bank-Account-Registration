package com.codingNinjas.Bank.Account.Registration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("savingsAccount")
@Scope("prototype")
public class savingsAccount implements Account{
    double amount = 0;

    @PostConstruct
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
