package com.testvagrant.testingchallenge;

import java.util.HashSet;
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

		// The input to the program should be a comma separated list of papers that the consumer wants to subscribe.
		String str;
		String[] strArr;
		scn = new Scanner(System.in);

		// Reading the data from the user
		System.out.println(
				"Enter Newspaper whose monthly subscription needs to be calculated. Choices are :: " + allCategories);
		System.out.println(
				"The input to the program should be a comma separated list of papers that the consumer wants to subscribe"
						+ " followed by Daily,Weekly,Biweekly (eg: TOI,Daily,ET,Weekly,HM,BiWeekly)");
		System.out.print("Enter your string here :: ");
		str = scn.next();
		str = str.replaceAll(" ", "");
		HashSet<String> hs = new HashSet<String>();

	}

}
