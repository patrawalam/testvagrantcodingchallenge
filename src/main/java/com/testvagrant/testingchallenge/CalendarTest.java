package com.testvagrant.testingchallenge;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarTest {
	
	static HashMap<String, Integer> hm = null;
	
	public static HashMap<String, Integer> daysInAMonth(int year, String month){
		hm = new HashMap<String, Integer>();
		
		Calendar cal = Calendar.getInstance();
		int calMonth = getCalendarMonth(month);
		cal.set(year, calMonth, 1);
		
		
		int totalDaysInGivenMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("Total number of days in the Month \'"+month+"\' and Year \'"+year+ "\' is :: " +totalDaysInGivenMonth);
		
		hm.put("Sunday", getDay(year, calMonth, 1));
		hm.put("Monday", getDay(year, calMonth, 2));
		hm.put("Tuesday", getDay(year, calMonth, 3));
		hm.put("Wednesday", getDay(year, calMonth, 4));
		hm.put("Thursday", getDay(year, calMonth, 5));
		hm.put("Friday", getDay(year, calMonth, 6));
		hm.put("Saturday", getDay(year, calMonth, 7));
		
		
		return hm;
	}
	
	private static int getCalendarMonth(String month) {
		int returnMonth = 0;
		switch(month) {
		case "Jan" : 
			returnMonth = Calendar.JANUARY;
			break;
		case "Feb" : 
			returnMonth = Calendar.FEBRUARY;
			break;
		case "Mar" : 
			returnMonth = Calendar.MARCH;
			break;
		case "Apr" : 
			returnMonth = Calendar.APRIL;
			break;
		case "May" : 
			returnMonth = Calendar.MAY;
			break;
		case "Jun" : 
			returnMonth = Calendar.JUNE;
			break;
		case "Jul" : 
			returnMonth = Calendar.JULY;
			break;
		case "Aug" : 
			returnMonth = Calendar.AUGUST;
			break;
		case "Sep" : 
			returnMonth = Calendar.SEPTEMBER;
			break;
		case "Oct" : 
			returnMonth = Calendar.OCTOBER;
			break;
		case "Nov" : 
			returnMonth = Calendar.NOVEMBER;
			break;
		case "Dec" : 
			returnMonth = Calendar.DECEMBER;
			break;
			
		}
			return returnMonth;
	}

	private static int getDay(int year, int month, int dayOfWeek) 
    { 
    int count=0; 
    Calendar calendar=Calendar.getInstance(); 
    calendar.set(year, month,1); 
    int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); 

    for(int i=1;i<=days;i++) 
    { 
     
            calendar.set(year, month, i); 
            int day=calendar.get(Calendar.DAY_OF_WEEK); 
            if(day==dayOfWeek) 
            count++        ; 
     
    } 
            return count; 
    } 
	
	
	public static void main(String[] args) {
		
		//We need to find out number of weekdays/saturday/sunday of any given month in any given year
		System.out.println(daysInAMonth(2020, "Feb"));
	}
	
}
