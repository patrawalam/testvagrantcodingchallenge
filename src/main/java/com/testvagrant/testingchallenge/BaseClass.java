package com.testvagrant.testingchallenge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	static Properties prop = null;
	static FileInputStream fs = null;
	
	public static String setupProperties(String fileName) {
		
		if(prop == null && fs == null) {
			prop = new Properties();
		}
		try {
			fs = new FileInputStream("./src/test/resources/project.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Issue with setting up Properties file");
			System.exit(0);
		}
		
		try {
			prop.load(fs);
		} catch (IOException e) {
			System.out.println("Issue with setting up Properties file");
			System.exit(0);
		}
		
		
		return (String)prop.get(fileName);
	}
}
