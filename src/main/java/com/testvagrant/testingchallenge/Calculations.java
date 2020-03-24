package com.testvagrant.testingchallenge;

import java.util.HashMap;

import com.testvagrant.testingchallenge.util.Xls_Reader;

public class Calculations {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, Double>> paper = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, Double> hm = null;
		Xls_Reader xls = new Xls_Reader(
				"D:\\SeleniumFiles\\EclipseWorkspaceForPractice\\TestingChallenge\\src\\test\\resources\\CategoryPrices.xlsx");

		System.out.println(xls.getRowCount("Tables"));
		
		
			for (int i = 2; i <=xls.getRowCount("Tables"); i++) {
				hm = new HashMap<String, Double>();
				hm.put("Monday", Double.parseDouble(xls.getCellData("Tables", "Monday", i)));
				hm.put("Tuesday", Double.parseDouble(xls.getCellData("Tables", "Tuesday", i)));
				hm.put("Wednesday", Double.parseDouble(xls.getCellData("Tables", "Wednesday", i)));
				hm.put("Thursday", Double.parseDouble(xls.getCellData("Tables", "Thursday", i)));
				hm.put("Friday", Double.parseDouble(xls.getCellData("Tables", "Friday", i)));
				hm.put("Saturday", Double.parseDouble(xls.getCellData("Tables", "Saturday", i)));
				hm.put("Sunday", Double.parseDouble(xls.getCellData("Tables", "Sunday", i)));
				
				paper.put(xls.getCellData("Tables", "Category", i),hm);
			}
		
			System.out.println(paper);
	}
}
