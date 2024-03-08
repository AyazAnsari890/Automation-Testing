package com.datadriven.framework.utils;

import java.util.Date;

public class DateUtils {
	
public static String getTimeStamp(){
		
		Date date = new Date();
		//to print the current data
		//System.out.println(date.toString());
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");

}
}
