/*
 * @author - Murtaza Ismail Patrawala
 * Date created: 24th March, 2020.
 * Date updated: 31st March, 2020.
 * Test Vagrant Coding Challenge 
 * 
 */


package com.testvagrant.challenge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

import com.testvagrant.challenge.util.Xls_Reader;

public abstract class BaseClass implements Prototype {
	
	public enum monthValue{
		Jan,
		Feb,
		Mar,
		Apr,
		May,
		Jun,
		Jul,
		Aug,
		Sep,
		Oct,
		Nov,
		Dec
	}

	protected Properties prop = null;
	protected FileInputStream fs = null;
	protected Xls_Reader xls = null;
	protected String fileName;

	public BaseClass(String fileName) {
		this.fileName = fileName;
		if (prop == null && fs == null) {
			prop = new Properties();
		}
		try {
			fs = new FileInputStream("./src/test/resources/project.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Issue with setting up Properties file");
			System.exit(0);
		}

		try {
			prop.load(fs);
		} catch (IOException e) {
			System.out.println("Issue with setting up Properties file");
			System.exit(0);
		}
		xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\resources\\"+prop.getProperty(fileName));
	}

	@Override
	public HashMap<String, HashMap<String, Double>> returnExcelData(String fileName) {
		HashMap<String, HashMap<String, Double>> excelData = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, Double> hashMap = null;
		
		//System.out.println(xls.getRowCount("Tables"));
			for (int i = 2; i <=xls.getRowCount("Tables"); i++) {
				hashMap = new HashMap<String, Double>();
				hashMap.put("Monday", Double.parseDouble(xls.getCellData("Tables", "Monday", i)));
				hashMap.put("Tuesday", Double.parseDouble(xls.getCellData("Tables", "Tuesday", i)));
				hashMap.put("Wednesday", Double.parseDouble(xls.getCellData("Tables", "Wednesday", i)));
				hashMap.put("Thursday", Double.parseDouble(xls.getCellData("Tables", "Thursday", i)));
				hashMap.put("Friday", Double.parseDouble(xls.getCellData("Tables", "Friday", i)));
				hashMap.put("Saturday", Double.parseDouble(xls.getCellData("Tables", "Saturday", i)));
				hashMap.put("Sunday", Double.parseDouble(xls.getCellData("Tables", "Sunday", i)));
				
				excelData.put(xls.getCellData("Tables", "Category", i),hashMap);
			}
		
			//System.out.println(excelData);
			return excelData;
	}

	@Override
	public HashMap<String, Integer> daysInAMonth(int year, String month) {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
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

	private int getCalendarMonth(String month) {
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

	private int getDay(int year, int month, int dayOfWeek) 
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

	
}
