package roughwork;

import java.util.Calendar;

public class Roughwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		  int year = 2021;
		  int month = Calendar.JANUARY;
		  int date = 1;
		  System.out.println(month);
		  calendar.set(year, month, date);
		  int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		  System.out.println("Number of Days: " + days);
	}

}
