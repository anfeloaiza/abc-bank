package com.abc;

public class Checking extends Account {

	@Override
	public double getInterest(double amount) {
		for(int i=0; i<DateProvider.getNumberOfDaysYear(); i++){
			amount += amount * (0.001 /DateProvider.getNumberOfDaysYear());
		}
		return amount;
	}

	@Override
	public String getDescription() {
		return "Checking Account";
	}
	
	

}
