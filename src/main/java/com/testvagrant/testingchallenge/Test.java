package com.testvagrant.testingchallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		//The input to the program should be a comma separated list of papers that the consumer wants to subscribe.
		String str;
		String[] strArr;
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Papers whose monthly subscription needs to be calculated. Choices are :: TOI, Hindu, ET, BM and HT");
		System.out.println("The input to the program should be a comma separated list of papers that the consumer wants to subscribe.");
		System.out.print("Enter your string here :: ");
		str = scn.next();
		str = str.replaceAll(" ", "");
		HashSet<String> hs = new HashSet<String>();
		
		strArr = str.split(",");
		
		for (String s : strArr) {
			if(s.equalsIgnoreCase("TOI") || s.equalsIgnoreCase("Hindu") || s.equalsIgnoreCase("ET") 
					|| s.equalsIgnoreCase("BM") || s.equalsIgnoreCase("HT"))
				hs.add(s);
		}
		
		System.out.println(hs);
	
		System.out.println("*******************************************************************");
		System.out.print("Enter the Year and Month (using first three letters only) seperated by comma whose budget needs calculated :: ");
		str = scn.next();
		strArr = str.split(",");
		int year = Integer.parseInt(strArr[0]);
		String month = strArr[1];
		
		
		HashMap<String, Integer> hm = CalendarTest.daysInAMonth(year, month);
		System.out.println(hm);
	
	}
}
