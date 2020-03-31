/*
 * @author - Murtaza Ismail Patrawala
 * Date created: 24th March, 2020.
 * Date updated: 31st March, 2020.
 * Test Vagrant Coding Challenge 
 * 
 */


package com.testvagrant.challenge.base;

import java.util.HashMap;

public interface Prototype {

	public HashMap<String, HashMap<String, Double>> returnExcelData(String fileName);
	
	public HashMap<String, Integer> daysInAMonth(int year, String month);
	
	public void calculateMonthlySubscriptions();
}
