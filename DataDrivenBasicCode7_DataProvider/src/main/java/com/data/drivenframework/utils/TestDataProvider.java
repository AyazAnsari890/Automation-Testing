package com.data.drivenframework.utils;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestDataProvider {

	
	@Test(dataProvider="getTestData")
	public void sampleTestOne(String col1, String col2, String col3, String col4, String col5, String col6) { 
		//System.err.println(table.get("Col2 "));
	}
	

	/************** To the Data for TestCase ******************/
	@DataProvider
	public static Object[][] getTestData() {

		ReadExcelDataFile readdata = new ReadExcelDataFile(
				System.getProperty("user.dir") + "\\src\\main\\java\\testdata\\TestData_Testmanagement.xlsx");
		String sheetName = "Feature 1";
		String testName = "Test Two";

		// Find Start Row of TestCase
		int startRowNum = 0;
		while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
			startRowNum++;
		}
		
		int startTestColumn = startRowNum + 1;
		int startTestRow = startRowNum + 2;

		// Find Number of Rows of TestCase
		int rows = 0;
		while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) {
			rows++;
		}
		
		// Find Number of Columns in Test
		int colmns = 0;
		while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) {
			colmns++;
		}
		
		//Define Two Object Array
		Object[][] dataSet = new Object[rows][colmns];	
		int dataRowNumber=0;
		for (int rowNumber = startTestRow; rowNumber <= startTestColumn + rows; rowNumber++) {
			for (int colNumber = 0; colNumber < colmns; colNumber++) {
				
				dataSet[dataRowNumber][colNumber]=readdata.getCellData(sheetName, colNumber, rowNumber);
				//00,01,02,03
				//10,11,12
			}
			dataRowNumber++;
		}
	 return dataSet;
	}
}

