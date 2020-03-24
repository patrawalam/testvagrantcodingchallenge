package com.testvagrant.testingchallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import com.testvagrant.testingchallenge.util.Xls_Reader;

public class Test {
	
	public static Scanner scn;

	public static void main(String[] args) {
		
		Xls_Reader xls = new Xls_Reader(
				"D:\\SeleniumFiles\\EclipseWorkspaceForPractice\\TestingChallenge\\src\\test\\resources\\CategoryPrices.xlsx");
		HashSet<String> allCategories = new HashSet<String>();
		for (int i = 2; i <=xls.getRowCount("Tables"); i++) {
			allCategories.add(xls.getCellData("Tables", "Category", i));
		}
		
		//The input to the program should be a comma separated list of papers that the consumer wants to subscribe.
		String str;
		String[] strArr;
		 scn = new Scanner(System.in);
		
		System.out.println("Enter Papers whose monthly subscription needs to be calculated. Choices are :: "+allCategories);
		System.out.println("The input to the program should be a comma separated list of papers that the consumer wants to subscribe (eg: TOI,ET)");
		System.out.print("Enter your string here :: ");
		str = scn.next();
		str = str.replaceAll(" ", "");
		HashSet<String> hs = new HashSet<String>();
		
		strArr = str.split(",");
		
		for (String s : strArr) {
			if(allCategories.contains(s))
				hs.add(s);
		}
		
		System.out.println(hs);	//[TOI, ET]
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println();
		System.out.print("Enter the Year followed by Month (using first three letters only) seperated by comma whose budget needs calculated (eg: 2020,Mar) :: ");
		str = scn.next();
		strArr = str.split(",");
		int year = Integer.parseInt(strArr[0]);
		String month = strArr[1];
		
		
		HashMap<String, Integer> hm = CalendarTest.daysInAMonth(year, month);
		System.out.println(hm);	//{Monday=5, Thursday=4, Friday=4, Sunday=5, Wednesday=4, Tuesday=5, Saturday=4}
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println();
		
		HashMap<String, HashMap<String, Double>> excelData = ExcelData.returnExcelData();
		//{Hindu={Monday=2.5, Thursday=2.5, Friday=2.5, Sunday=4.0, Wednesday=2.5, Tuesday=2.5, Saturday=4.0},
		//BM={Monday=1.5, Thursday=1.5, Friday=1.5, Sunday=1.5, Wednesday=1.5, Tuesday=1.5, Saturday=1.5}, 
		//HT={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=4.0, Wednesday=2.0, Tuesday=2.0, Saturday=4.0}, 
		//TOI={Monday=3.0, Thursday=3.0, Friday=3.0, Sunday=6.0, Wednesday=3.0, Tuesday=3.0, Saturday=5.0}, 
		//ET={Monday=2.0, Thursday=2.0, Friday=2.0, Sunday=10.0, Wednesday=2.0, Tuesday=2.0, Saturday=2.0}}
		HashMap<String, Double> calcHashMap = new HashMap<String, Double>();
		double sum = 0;
		double multiply;
		for (String s: hs) {
			if (excelData.containsKey(s))
			{
				calcHashMap = excelData.get(s);
				System.out.println("Calculation Table for \'"+s+"\' is :: "+calcHashMap);  	//Hindu --- {Monday=2.5, Thursday=2.5, Friday=2.5, Sunday=4.0, Wednesday=2.5, Tuesday=2.5, Saturday=4.0}
				multiply = 0;
				for(Map.Entry<String, Integer> e : hm.entrySet()) {
					multiply = multiply + (e.getValue() * calcHashMap.get(e.getKey()));
				}
				
				System.out.println("Total Monthly subscription for "+s+" is Rs "+multiply);
				sum = sum + multiply;
			}
			
			
		}
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println();
		System.out.println("Total estimated subscription amount for the month of \'"+month+"\' and year \'"+year+"\' is  :: Rs "+sum);
	}
}
