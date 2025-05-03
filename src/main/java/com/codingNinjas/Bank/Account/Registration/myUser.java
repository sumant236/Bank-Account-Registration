package com.codingNinjas.Bank.Account.Registration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("myUser")
public class myUser implements User{

    String name;
    List<Account> accountList;

//    Account accountType;
//
//    @Autowired
//    @Qualifier("savingsAccount")
//    Account savingAccount;
//
//    @Autowired
//    @Qualifier("currentAccount")
//    Account currentAccount;
//
//    public void setAccountType(String account){
//        if(account.equals("savingsAccount"))
//            this.accountType = this.savingAccount;
//        else
//            this.accountType = this.currentAccount;
//    }

    @PostConstruct
    public void init(){
        System.out.println("User bean has been instantiated and I'm the init() method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("User bean has been closed and I'm the destroy() method");
    }

    public myUser() {
        accountList = new ArrayList<>();
    }

    @Override
    public void setUserDetails(String name) {
        this.name = name;
    }

    @Override
    public void addAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.accountList;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
