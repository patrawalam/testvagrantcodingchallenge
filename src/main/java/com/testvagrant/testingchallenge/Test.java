package com.testvagrant.testingchallenge;

import java.util.HashSet;
import java.util.Scanner;

public class Test {

	static Scanner scn = null;
	
	public static void main(String[] args) {
		
		//The input to the program should be a comma separated list of papers that the consumer wants to subscribe.
		
		scn = new Scanner(System.in);
		
		System.out.println("Enter Papers whose monthly subscription needs to be calculated. Choices are :: TOI, Hindu, ET, BM and HT");
		System.out.println("The input to the program should be a comma separated list of papers that the consumer wants to subscribe.");
		System.out.print("Enter your string here :: ");
		String str = scn.next();
		str = str.replaceAll(" ", "");
		HashSet<String> hs = new HashSet<String>();
		
		String[] strArr = str.split(",");
		
		for (String s : strArr) {
			if(s.equalsIgnoreCase("TOI") || s.equalsIgnoreCase("Hindu") || s.equalsIgnoreCase("ET") 
					|| s.equalsIgnoreCase("BM") || s.equalsIgnoreCase("HT"))
				hs.add(s);
		}
		
		System.out.println(hs);
	}

}
