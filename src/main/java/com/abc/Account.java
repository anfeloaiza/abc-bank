package com.abc;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

	public List<Transaction> transactions;

	public Account() {
		this.transactions = new ArrayList<Transaction>();
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount));
		}
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(-amount));
		}
	}
	
	public double interestEarned(){
		
		double amount = sumTransactions();
		double amountPlusInterest = getInterest(amount);
		
		return amountPlusInterest - amount;
	}
	
	public abstract double getInterest(double amount);

	public double sumTransactions() {
		return getAccountAmount();
	}

	private double getAccountAmount() {
		double amount = 0.0;
		for (Transaction t : transactions)
			amount += t.amount;
		return amount;
	}

	public void transfer(double amount, Account destinyAccount){
		this.withdraw(amount);
		destinyAccount.deposit(amount);
	}
	
	public abstract String getDescription();

}
