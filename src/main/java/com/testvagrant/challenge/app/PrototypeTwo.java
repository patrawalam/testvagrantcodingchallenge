/*
 * @author - Murtaza Ismail Patrawala
 * Date created: 24th March, 2020.
 * Date updated: 31st March, 2020.
 * Test Vagrant Coding Challenge 
 * 
 */

package com.testvagrant.challenge.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import com.testvagrant.challenge.base.BaseClass;

public class PrototypeTwo extends BaseClass{

	public Scanner scn;

	public PrototypeTwo(String nameOfApp) {
		super(nameOfApp);
	}

	public void calculateMonthlySubscriptions() {

		// Reading the category column data from the Excel file which contains category/day-cost values
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
				"Enter Categories whose monthly subscription needs to be calculated. Choices are :: " + allCategories);
		/*
		 * System.out.println(
		 * "The input to the program should be a comma separated list of categories that the consumer wants to subscribe"
		 * +
		 * " followed by Daily,Weekly,Biweekly (eg: TOI,Daily,ET,Weekly,HM,BiWeekly)");
		 */
		System.out.print("Enter your string here :: ");
		str = scn.next();
		
		strArr = str.split(",");
		HashSet<String> hs = new HashSet<String>();
		boolean b = false;
		System.out.println();
		for (String s : strArr) {
			if(allCategories.contains(s))	//allCategories=[Hindu, Carwash, BM, HT, Magazine, TOI, ET, Milk]
											//strArr = BM,Daily,BM,Daily,ET,Blah,Blah,Weekly,HT,Daily,TOI,Daily,Milk,Daily,Magazine,Weekly,Carwash,Biweekly
				b = hs.add(s);
			else 
				b = false;
			if (b == false)
				System.out.println("Incorrect or duplicate category \'"+s+"\' was entered. This will not be considered");
		}
		System.out.println();
		if(!(hs.size() > 0)) {
			System.out.println("No proper categories entered by user. Exiting the program. Please run again");
			System.exit(0);
		}
		System.out.println();
		System.out.println("This is the final category on which monthly subscription will be calculated :: "+hs);	//[TOI, ET]
		System.out.println();
		
		ArrayList<String> al = new ArrayList<String>(hs);
		HashMap<String, String> hmForCategoryFrequency = new HashMap<String, String>();
		System.out.println();
		//Irrespective of what the user enters, if the category is available, add it to the HashSet
		for (int i=0;i<al.size();i++) {
			System.out.println();
			System.out.print("Enter frequency of purchase of product \'"+al.get(i)+"\'. Options are Daily, Weekly, BiWeekly :: ");
			str = scn.next();
			if(str.equalsIgnoreCase("Daily") || str.equalsIgnoreCase("Weekly") || str.equalsIgnoreCase("Biweekly"))
				hmForCategoryFrequency.put(al.get(i), str);
			else {
				System.out.println();
				System.out.println("The frequency \'"+str+"\' wasnt chosen correctly. Hence product \'"+al.get(i)+"\' will be ignored");
				System.out.println();
			}
		}
		
		//If the user entered any other values apart from the given choice, it will terminate the program
		if(hmForCategoryFrequency.isEmpty()) {
			System.out.println("No proper combination of categories/frequency entered by user. Exiting the program. Please run again");
			System.exit(0);
		}
		System.out.println();
		System.out.println("This is the final category and frequency on which monthly subscription will be calculated :: "+hmForCategoryFrequency);	//[TOI, ET]//{Hindu=Daily, ET=Weekly, TOI=Biweekly}
		System.out.println();
		
		//Takes the input from the user about the Month and Year in which the user wants to calculate subscription for
		System.out.println("*******************************************************************");
		System.out.println();
		System.out.print("Enter the Year followed by Month (using first three letters only) seperated by comma whose budget needs calculated (eg: 2020,Mar) :: ");
		str = scn.next();
		strArr = str.split(",");
		int year = 0;
		String month = "";
		try {
		year = Integer.parseInt(strArr[0]);
		}
		catch(NumberFormatException e) {
			System.out.println();
			System.out.println("Year entered is not a valid number. Exiting the program");
			System.exit(0);
		}

		month = strArr[1];
		boolean flagMonth = false;
		for (monthValue s : monthValue.values())
		{
			if (s.name().equals(month))
				flagMonth = true;
		}
		
		if (flagMonth == false) {
			System.out.println();
			System.out.println("Month selection is not correct. It should be first three letters of the Month only. Exiting the Program. Please run again");
			System.exit(0);
		}
		
		//Using the Month and Year passed by the user above, calls the method daysInAMonth to get the number of days for each day in the month
		HashMap<String, Integer> hm = daysInAMonth(year, month);
		System.out.println(hm);	//{Monday=5, Thursday=4, Friday=4, Sunday=5, Wednesday=4, Tuesday=5, Saturday=4}
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println();
		
		//Retrieves the excel data by calling method returnExcelData which defines daily cost on each day for each category. 
		HashMap<String, HashMap<String, Double>> excelData = returnExcelData(fileName);
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
		System.out.println();
		System.out.println();
		System.out.println();
	}
		
	
}
