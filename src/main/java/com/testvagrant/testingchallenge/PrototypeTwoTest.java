package com.testvagrant.testingchallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import com.testvagrant.testingchallenge.util.Xls_Reader;

public class PrototypeTwoTest {

	public static Scanner scn;

	public static void main(String[] args) {

		// Reading the category column data from the Excel file which contains category/day-cost values
		Xls_Reader xls = new Xls_Reader(
				"D:\\SeleniumFiles\\EclipseWorkspaceForPractice\\TestingChallenge\\src\\test\\resources\\CategoryPrices.xlsx");
		HashSet<String> allCategories = new HashSet<String>();
		for (int i = 2; i <= xls.getRowCount("Tables"); i++) {
			allCategories.add(xls.getCellData("Tables", "Category", i));
		}

		// The input to the program should be a comma separated list of categories followed by frequency that the consumer wants to subscribe.
		String str;
		String[] strArr;
		scn = new Scanner(System.in);

		// Reading the data from the user
		System.out.println(
				"Enter category followed by frequency whose subscription needs to be calculated. Choices are :: " + allCategories);
		System.out.println(
				"The input to the program should be a comma separated list of categories that the consumer wants to subscribe"
						+ " followed by Daily,Weekly,Biweekly (eg: TOI,Daily,ET,Weekly,HM,BiWeekly)");
		System.out.print("Enter your string here :: ");
		str = scn.next();
		str = str.replaceAll(" ", "");
		HashMap<String, String> hmForCategoryFrequency = new HashMap<String, String>();
		
		strArr = str.split(",");
		
		//Irrespective of what the user enters, if the category is available, add it to the HashSet
		for (int i=0;i<strArr.length;i = i+2) {
			if(allCategories.contains(strArr[i]) &&	
					(strArr[i+1].equalsIgnoreCase("Daily") ||strArr[i+1].equalsIgnoreCase("Weekly") || strArr[i+1].equalsIgnoreCase("Biweekly") ))
				hmForCategoryFrequency.put(strArr[i], strArr[i+1]);
		}
		
		System.out.println(hmForCategoryFrequency);	//{Hindu=Daily, ET=Weekly, TOI=Biweekly}

		
		//If the user entered any other values apart from the given choice, it will terminate the program
		if(hmForCategoryFrequency.isEmpty()) {
			System.out.println("No proper combination of categories/frequency entered by user. Exiting the program. Please run again");
			System.exit(0);
		}
		
		//Takes the input from the user about the Month and Year in which the user wants to calculate subscription for
		System.out.println("*******************************************************************");
		System.out.println();
		System.out.print("Enter the Year followed by Month (using first three letters only) seperated by comma whose budget needs calculated (eg: 2020,Mar) :: ");
		str = scn.next();
		strArr = str.split(",");
		int year = Integer.parseInt(strArr[0]);
		String month = strArr[1];
		
		//Using the Month and Year passed by the user above, calls the static method daysInAMonth to get the number of days for each day in the month
		HashMap<String, Integer> hm = CalendarTest.daysInAMonth(year, month);
		System.out.println(hm);	//{Monday=5, Thursday=4, Friday=4, Sunday=5, Wednesday=4, Tuesday=5, Saturday=4}
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println();
		
		//Retrieves the excel data by calling static method returnExcelData which defines daily cost on each day for each category. 
		HashMap<String, HashMap<String, Double>> excelData = ExcelData.returnExcelData();
		//{Hindu={Monday=2.5, Thursday=2.5, Friday=2.5, Sunday=4.0, Wednesday=2.5, Tuesday=2.5, Saturday=4.0},
		//BM={Monday=1.5, Thursday=1.5, Friday=1.5, Sunday=1.5, Wednesday=1.5, Tuesday=1.5, Saturday=1.5}, 
		//HT={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=4.0, Wednesday=2.0, Tuesday=2.0, Saturday=4.0}, 
		//TOI={Monday=3.0, Thursday=3.0, Friday=3.0, Sunday=6.0, Wednesday=3.0, Tuesday=3.0, Saturday=5.0}, 
		//ET={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=10.0, Wednesday=2.0, Tuesday=2.0, Saturday=2.0}}
		
		//Calculations
		HashMap<String, Double> calcHashMap = new HashMap<String, Double>();
		double sum = 0;
		double multiply;
		for (Map.Entry<String,String> e : hmForCategoryFrequency.entrySet()) {
			if(e.getValue().equalsIgnoreCase("Daily")) {
				if (excelData.containsKey(e.getKey()))
				{
					calcHashMap = excelData.get(e.getKey());
					System.out.println("Calculation Table for \'"+e.getKey()+"\' is :: "+calcHashMap);  	//ET={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=10.0, Wednesday=2.0, Tuesday=2.0, Saturday=2.0}}
					multiply = 0;
					for(Map.Entry<String, Integer> es : hm.entrySet()) {
						multiply = multiply + (es.getValue() * calcHashMap.get(es.getKey()));
					}
					
					System.out.println("Total Monthly subscription for "+e.getKey()+" is Rs "+multiply);
					System.out.println();
					sum = sum + multiply;
				}
			}
			else if (e.getValue().equalsIgnoreCase("Weekly")){
				if (excelData.containsKey(e.getKey()))
				{
					calcHashMap = excelData.get(e.getKey());
					System.out.println("Calculation Table for \'"+e.getKey()+"\' is :: "+calcHashMap);  	//ET={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=10.0, Wednesday=2.0, Tuesday=2.0, Saturday=2.0}}
					multiply = 0;
					for(Map.Entry<String, Integer> es : hm.entrySet()) {
						multiply = multiply + (1 * calcHashMap.get(es.getKey()));
					}
					multiply = multiply/7;
					System.out.println("Total Weekly subscription for "+e.getKey()+" is Rs "+multiply);
					System.out.println("Therefore, total Monthly subscription for "+e.getKey()+" is Rs "+multiply*4);
					System.out.println();
					sum = sum + (multiply*4);
				}
				}
			else if(e.getValue().equalsIgnoreCase("Biweekly")){
				if (excelData.containsKey(e.getKey()))
				{
					calcHashMap = excelData.get(e.getKey());
					System.out.println("Calculation Table for \'"+e.getKey()+"\' is :: "+calcHashMap);  	//ET={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=10.0, Wednesday=2.0, Tuesday=2.0, Saturday=2.0}}
					multiply = 0;
					for(Map.Entry<String, Integer> es : hm.entrySet()) {
						multiply = multiply + (2 * calcHashMap.get(es.getKey()));
					}
					multiply = multiply/14;
					System.out.println("Total Biweekly subscription for "+e.getKey()+" is Rs "+multiply);
					System.out.println("Therefore, total monthly subscription for "+e.getKey()+" is Rs "+multiply*2);
					System.out.println();
					sum = sum + (multiply*2);
				}
				}
			
		}
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println();
		System.out.println("Total estimated subscription amount for the month of \'"+month+"\' and year \'"+year+"\' is  :: Rs "+sum);
	}
		
	
}
