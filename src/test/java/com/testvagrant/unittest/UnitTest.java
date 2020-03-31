/*
 * @author - Murtaza Ismail Patrawala
 * Date created: 24th March, 2020.
 * Date updated: 31st March, 2020.
 * Test Vagrant Coding Challenge 
 * 
 */


package com.testvagrant.unittest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

import com.testvagrant.challenge.app.ApplicationRunner;

public class UnitTest {

	@Test(description = "This is the test created for calculating the Monthly Newspaper subscription for any given month"
			+ " in any given year based on the user input",
			enabled=true)
	public void runPrototypeOne(Method m) {
		
		ApplicationRunner app = new ApplicationRunner();
		app.runApplication(m.getName());
	}
	
	@Test(description = "This is the test created for calculating the Monthly subscriptions for any category for any given month and year"
			+ " in either Weekly/BiWeekly/Daily format based on the user input",
			enabled=false)
	public void runPrototypeTwo(Method m) {
		
		ApplicationRunner app = new ApplicationRunner();
		app.runApplication(m.getName());
	}
}
