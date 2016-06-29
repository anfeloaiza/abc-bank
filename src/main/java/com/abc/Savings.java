package com.abc;

public class Savings extends Account {

	@Override
	public double getInterest(double amount) {
		double amountPlusInterest = 0;
		if (amount <= 1000){
			amountPlusInterest = amount;
			for(int i=0; i<DateProvider.getNumberOfDaysYear(); i++){
				amountPlusInterest += amountPlusInterest * (0.001 /DateProvider.getNumberOfDaysYear());
			}
			return amountPlusInterest;
		}else{
			amountPlusInterest = amount-1000;
			for(int i=0; i<DateProvider.getNumberOfDaysYear(); i++){
				amountPlusInterest += amountPlusInterest * (0.002 /DateProvider.getNumberOfDaysYear());
			}
			return getBaseInterest() + amountPlusInterest;
		}
		
	}
	
	public double getBaseInterest(){
		double amount =1000;
		for(int i=0; i<DateProvider.getNumberOfDaysYear(); i++){
			amount += amount*(0.001 /DateProvider.getNumberOfDaysYear());
		}
		return amount;
	}

	@Override
	public String getDescription() {
		return "Savings Account";
	}

}
