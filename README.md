# Test Vagrant Coding Challenge
Objective: Repository created for Coding Challenge provided by Test Vagrant


The Table for adding categories along with the daily cost for each category is maintained separately in an Excel file named "CategoryPrices.xlsx" (Sheet: Tables) under src/test/resources folder<br/><br/>
******************************************************************************************************************
<br/>

# How to run:

**1) PrototypeOne** - This program calculates the "monthly" subscription of the newspapers entered by the user in comma separated list, for any given month in any given year.  

Sample Input data: 
- *At first user input* --> TOI,BM,HT,Random,TOI,Random,BM,@#@$,BM
- *At second user input* --> 2020,Apr

The "PrototypeOneExcel.xlsx" excel file contains a Sheet "ManualCheck" to tally with the results of the program

<br/><br/>

**2) PrototypeTwo** - This program calculates the subscription of **any** category based on frequency (Monthly, Weekly, Biweekly) for any given month in any given year.

Sample Input data: 
- *At first user input* --> BM,BM,Blah,Blah,HT,TOI,Milk,Magazine,Carwash,Bikewash
- *At every second user input* --> Daily or Weekly or Biweekly

The "PrototypeTwoExcel.xlsx" excel file contains a Sheet "ManualCheck" to tally with the results of the program

<br/><br/>


In order to run the code <br/>
1) Navigate to src/test/java/com/testvagrant/unittest --- File name "UnitTest.java".<br/>
2) Out of the two Unit Test cases, set "enabled=true" for whichever test you want to run.<br/>
3) Enter valid inputs to see the calculations. Enter invalid inputs to see appropriate messages.<br/>

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


## 31st March) Version 2.0
1) Refactored all the code to add OOD by creating interface, abstract class and using Reflection to run the appropriate test case at runtime by creating respective Object of Class.<br/>
2) Segregated code in appropriate packages<br/>
3) Used concept of Constructor to initialize the XLS_Reader Object by reading Excel file name from Properties file<br/>
4) Removed all static references<br/>
5) Used enums for one scenario to test if correct month is entered by user<br/>
6) Used System.exit(0) instead of throwing exceptions for abrupt termination with appropriate messages<br/>
7) Unit tests added. Kindly trigger UnitTest by setting "enabled=true"<br/>
