package com.data.drivenframework.utils;



public class tempreadData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//In this class we work with TestData.xlsx file
		ReadExcelDataFile readData = new ReadExcelDataFile(System.getProperty("user.dir") + "\\src\\main\\java\\testData\\TestData.xlsx");
		
		int totalRows = readData.getRowCount("SampleData");
		System.out.println("Total Number of Rows : " + totalRows);
		
		System.out.println(readData.getCellData("SampleData", 0, 3));
		System.out.println(readData.getCellData("SampleData", 1, 4));
		
		System.out.println(readData.getColumnCount("SampleData"));

	}
}
