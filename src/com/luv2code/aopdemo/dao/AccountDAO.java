package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

import java.util.ArrayList;
import java.util.List;

@Component()
public class AccountDAO {

	boolean testBoolean = true;

	public void addAccount(Account theAccount, boolean vipFlag) {

		
		System.out.println(getClass() +  ": DOING MY DBWORK: ADDING AN ACCOUNT");
	}

	public void updateAccount() {
		
		System.out.println("AccountDAO updateAccount()!");
		
	}

	public List<Account> findAccounts(){
		List<Account> theAccounts = new ArrayList<>();

		// creawte sample accounts
		Account temp1 = new Account("John", "1");
		Account temp2 = new Account("Madhu", "2");
		Account temp3 = new Account("Luca", "3");



		// add them to our accounts list
		theAccounts.add(temp1);
		theAccounts.add(temp2);
		theAccounts.add(temp3);
		if (testBoolean) {
			throw new RuntimeException("I am the RuntimeException in findAccount ");
		}
		return theAccounts;
	}
	
}
