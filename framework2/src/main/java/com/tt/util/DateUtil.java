package com.tt.util;




import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String dateformat = "dd-MM-yyyy:HH:mm:ss";
	
	public static String getCurrentDate(String format)
	{
		String output = "";
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		output = df.format(d);
		return output;
		
	}
	public static String getCurrentDate()
	{
		return getCurrentDate(dateformat);
	 	
	}
	
	
	public static String getCalendar(String increment, int factor)
	{
		String output="";
		Calendar ca = Calendar.getInstance();
		if(increment.equalsIgnoreCase("MONTH"))
		   ca.add(Calendar.MONTH, factor);
		else if(increment.equalsIgnoreCase("DATE"))
			   ca.add(Calendar.DATE, factor);
		
		
		Date d = ca.getTime();
		SimpleDateFormat df = new SimpleDateFormat(dateformat);
		
		output =df.format(d);
		return output;
		
	}
	
	public static long TimeDifference(String before, String after)
	{
		long diff=0;
		try {
			Date d1 = new SimpleDateFormat(dateformat).parse(before);
			Date d2 = new SimpleDateFormat(dateformat).parse(after);
			
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");
			System.out.println(df.format(d1));
			System.out.println(df.format(d2));
			
			long beforeTime = d1.getTime();
			long afterTime = d2.getTime();
			
			System.out.println("After:"+ afterTime);
			System.out.println("Before:"+ beforeTime);
			diff = (afterTime-beforeTime)/1000;
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return diff;
	}
	public static void main(String args[]) {
		System.out.println("Date:"+DateUtil.getCurrentDate());
		System.out.println(DateUtil.getCalendar("MONTH",2));
		System.out.println("Time diff in sec:"+DateUtil.TimeDifference("31-01-2020:08:59:21", "01-02-2020:08:59:21"));
	}

}
