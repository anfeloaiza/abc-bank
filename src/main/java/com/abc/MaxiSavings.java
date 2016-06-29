package com.abc;

import java.time.LocalDate;
import java.time.Period;

public class MaxiSavings extends Account {

	@Override
	public double getInterest(double amount) {
		for(int i=0; i<DateProvider.getNumberOfDaysYear(); i++){
			amount += amount * (getInterestRate() /DateProvider.getNumberOfDaysYear());
		}
		return amount;
	}

	@Override
	public String getDescription() {
		return "Maxi Savings Account";
	}

	public double getInterestRate() {
		Period period;
		for (Transaction transaction : transactions) {
			if (transaction.amount < 0) {
				period = Period.between(transaction.getTransactionDate(), LocalDate.now());
				if (period.getDays() <= 10)
					return 0.001;
			}
		}
		return 0.05;
	}

}
