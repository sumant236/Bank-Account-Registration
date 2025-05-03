package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.codingNinjas.Bank.Account.Registration");
		ApplicationContext context = SpringApplication.run(BankAccountRegistrationApplication.class, args);

		System.out.println("Welcome to Account Registration Application!");
		System.out.println("Please enter Your name?");
		String name = sc.nextLine();

		User user = context.getBean(User.class);
		user.setUserDetails(name);

		System.out.println("Do you want to add account");
		System.out.println("1. Yes \n2. No");
		int userChoice = sc.nextInt();

		if(userChoice == 1){
			System.out.println("Please select the account type \n1. Current \n2. Savings");
			userChoice = sc.nextInt();

			Account account;

            if(userChoice == 1){
//				user.setAccountType("currentAccount");
				account = context.getBean("currentAccount", Account.class);
			} else if(userChoice == 2){
//				user.setAccountType("savingsAccount");
				account = context.getBean("savingsAccount", Account.class);
			} else {
				System.out.println("Invalid selection!!");
				return;
			}

//			Account account = ((myUser) user).accountType;

			System.out.println("Enter the opening balance");
			double amount = sc.nextDouble();
			sc.nextLine();

			account.addBalance(amount);
			user.addAccount(account);

			while(true){
				System.out.println("Do you want to add more accounts\n1. Yes\n2. No");
				userChoice = sc.nextInt();

				if(userChoice == 1){
					System.out.println("Please select the account type\n1. Current \n2. Savings");
					userChoice = sc.nextInt();

					if(userChoice == 1){
//				user.setAccountType("currentAccount");
						account = context.getBean("currentAccount", Account.class);
					} else if(userChoice == 2){
//				user.setAccountType("savingsAccount");
						account = context.getBean("savingsAccount", Account.class);
					} else {
						System.out.println("Invalid selection!!");
						return;
					}

//			Account account = ((myUser) user).accountType;

					System.out.println("Enter the opening balance");
					amount = sc.nextDouble();
					sc.nextLine();

					account.addBalance(amount);
					user.addAccount(account);
				} else {
					System.out.println("Hi " + user.getName() + ", here is the list of your accounts:");

					List<Account> accountList = user.getAllAccounts();
					for(Account acc : accountList){
						System.out.println(acc.getAccountType() + " : opening balance - " + acc.getBalance() + " Reference Id " + acc.toString().substring(57));
					}
					return;
				}
			}
		}
	}

}
