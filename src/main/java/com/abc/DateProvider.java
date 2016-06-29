package com.abc;

import java.time.LocalDate;
import java.time.Year;

public class DateProvider {

    public static LocalDate now() {
        return LocalDate.now();
    }
    
    public static int getNumberOfDaysYear(){
    	return Year.now().isLeap()?366:365;
    }
    
}
