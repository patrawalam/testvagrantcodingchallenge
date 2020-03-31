package roughwork;

import java.util.Calendar;

public class Roughwork {
	protected enum monthValue{
		Jan,
		Feb,
		Mar,
		Apr,
		May,
		Jun,
		Jul,
		Aug,
		Sep,
		Oct,
		Nov,
		Dec
	}
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
		  
		  for (monthValue e : monthValue.values())
			  System.out.println(e.name().equals("Jun"));
	}		

}
