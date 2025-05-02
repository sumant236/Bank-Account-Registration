package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		System.out.println("Welcome to Account Registration Application!");
		System.out.println("Please enter Your name?");
		String name = sc.nextLine();

		User user = (User) context.getBean("myUser");
		user.setUserDetails(name);

		System.out.println("Do you want to add account");
		System.out.println("1. Yes \n2. No");
		int userChoice = sc.nextInt();

		if(userChoice == 1){
			System.out.println("Please select the account type \n1. Current \n2. Savings");
			userChoice = sc.nextInt();

			Account account = null;
			if(userChoice == 1){
				account = (Account) context.getBean("currentAccount");
			} else if(userChoice == 2){
				account = (Account) context.getBean("savingAccount");
			} else {
				System.out.println("Invalid selection! Exiting...");
				context.close();
				return;
			}

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
						account = (Account) context.getBean("currentAccount");
					} else if(userChoice == 2){
						account = (Account) context.getBean("savingAccount");
					} else {
						System.out.println("Invalid selection! Exiting...");
						return;
					}

					System.out.println("Enter the opening balance");
					amount = sc.nextDouble();
					sc.nextLine();

					account.addBalance(amount);
					user.addAccount(account);
				} else {
					System.out.println("Hi " + user.getName() + ", here is the list of your accounts:");

					List<Account> accountList = user.getAllAccounts();
					for(Account acc : accountList){
						System.out.println(acc.getAccountType() + " : opening balance - " + acc.getBalance() + " Reference Id " + acc);
					}
					context.close();
					return;
				}
			}
		}
	}

}
