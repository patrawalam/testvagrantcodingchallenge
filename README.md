# Test Vagrant Coding Challenge
Objective: Repository created for Coding Challenge provided by Test Vagrant


The Table for adding categories along with the daily cost for each category is maintained separately in an Excel file named "CategoryPrices.xlsx" (Sheet: Tables) under src/test/resources folder<br/><br/>
******************************************************************************************************************
<br/>

# How to run:

**1) PrototypeOneTest** - This program calculates the "monthly" subscription of the papers entered by the user in comma seperated list, for any given month in any given year.  

Sample Input data: 
- *At first user input* --> TOI,BM,HT,Random,TOI,Random,BM,@#@$,BM
- *At second user input* --> 2020,Apr

The "CategoryPrices.xlsx" excel file contains a Sheet "ManualCheck" to tally with the results of the program



**2) PrototypeTwoTest** - This program calculates the subscription of **any** category based on frequency (Monthly, Weekly, Biweekly) for any given month in any given year.

Sample Input data: 
- *At first user input* --> Hindu,Daily,Hindu,Daily,ET,Blah,Blah,Weekly,ET,Weekly,TOI,Biweekly
- *At second user input* --> 2020,Mar

<br/><br/>

******************************************************************************************************************

<br/>

# History of changes done:

## A) For PrototypeOneTest

Step 1 - Taking the input from the user in the form of comma separated list. Splitting the list to String Array.
Based on Paper selection, adding them to HashSet to ensure no duplicates are added

Step 2 - Create an Excel called "CategoryPrices" which has a table created for category and prices based on day of the week.
Created a static method returnExcelData inside the Class called ExcelData which is responsible for returning the key-value pair of Day of the week with daily price for each NewsPaper using HashMap of HashMap.

Step 3 - Created a Class for Calendar manipulations. Created a public static method which accepts "Year" and "Month" (first 3 letters) and it returns a HashMap which contains number of Sundays, Mondays, Tuesday,..., Saturdays for that month.
This will be later used in calculation of monthly expense.

Step 4 - Integrating the CalendarTest code into PrototypeOneTest.java i.e. calling the static method "daysInAMonth" based on the user input

Step 5 - Integrated the ExcelData code into PrototypeOneTest.java ie. calling the static method "returnExcelData"

Step 6 - First working prototype published. 

Step 7 - Added code right at the start to read the Data from the Excel file and compare the user input with the categories mentioned in the Excel file. This makes using if condition easier i.e. using hashset "contains" method.

Step 8 - Added relevant comments for better readability


## B) For PrototypeTwoTest
User now enters Category along with Frequency in a comma separated list and the system calculates the estimated subscription amount.
 
