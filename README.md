# testvagrantcodingchallenge
Repository created for Coding Challenge provided by Test Vagrant




******************************************************************************************************************
History of changes done:

Step 1 - Taking the input from the user in the form of comma seperated list. Splitting the list to String Array.
Based on Paper selection, adding them to HashSet to ensure no duplicates are added

Step 2 - Create an Excel called "CategoryPrices" which has a table created for category and prices based on day of the week.
Created a Class called ExcelData where the code to add Day/Value pair for each category using HashMap of HashMap

Step 3 - Created a Class for Calendar manipulations. Created a public method which accepts "Year" and "Month" (first 3 letters) and it returns a HashMap which contains number of Sundays, Mondays, Tuesday, ..., Saturdays in that month.
This will be later used in calculation of monthly expense

Step 4 - Integrating the CalendarTest code into Test.java i.e. calling the static method "daysInAMonth" based on the user input

Step 5 - Integrated the ExcelData code into Test.java ie. calling the static method "returnExcelData"

Step 6 - First working prototype published. 
