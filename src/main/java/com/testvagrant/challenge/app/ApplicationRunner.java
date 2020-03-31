/*
 * @author - Murtaza Ismail Patrawala
 * Date created: 24th March, 2020.
 * Date updated: 31st March, 2020.
 * Test Vagrant Coding Challenge 
 * 
 */


package com.testvagrant.challenge.app;

import com.testvagrant.challenge.base.Prototype;

public class ApplicationRunner {
	
	Prototype p = null;

	public void runApplication(String nameOfApp) {
		
		if (nameOfApp.equalsIgnoreCase("runPrototypeOne")) {
			p = new PrototypeOne(nameOfApp);
			p.calculateMonthlySubscriptions();
		}
		else if (nameOfApp.equalsIgnoreCase("runPrototypeTwo")) {
			p= new PrototypeTwo(nameOfApp);
			p.calculateMonthlySubscriptions();
		}
		else {
			System.out.println("The method name should be either \'runPrototypeOne\' OR \'runPrototypeTwo\'. Please run again");
			System.exit(0);
		}
		
	}
}
