package com.sumadga.sms.utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

public class CommonUtils {
	
	   public static boolean isAlphabetic(String target){
	        return target.matches("[a-zA-Z]*");
	    }

	    public static boolean isNumeric(String target) {
	        return target.matches("[-+]?\\d*\\.?\\d+");
	    }

	    public static boolean isValidZipCode(String target) {
	        return target.matches("^\\d{5}\\p{Punct}?\\s?(?:\\d{4})?$");
	    }

	    public static boolean isValidPhoneNumber(String target) {
	        return target.matches("(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}");
	    }

	    public static boolean isValidEmail(String target) {
	        return target.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
	    }

	    public static boolean isValidLength(String target,Long size) {
	        return target.length() == size;
	    }

	    public static boolean isEmpty(String str) {
	        return (str == null || str.equals(""));
	    }
	  
	    public static boolean isValidSession(HttpSession session) {
	        if(session != null && session.isNew()){
	            return true;
	        }
	        return false;
	    }

	public static Date getStringToDate(String dateStr) {

		DateFormat fomatter = new SimpleDateFormat("dd-mm-yyyy");
		try {
			Date date = fomatter.parse(dateStr);
			System.out.println("Time : " + fomatter.format(date));
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	
	public static Time StringToTime(String timeStr){
		SimpleDateFormat df = new SimpleDateFormat("hh:mma");
		try {
			Date dt = df.parse(timeStr);
			Time time = new Time(dt.getTime());
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
			Date date = new Date();
			Time time = new Time(date.getTime());
			return time;
		}
		
	}
	
	public static String convertTime_ToSpecific_TimeFormat(Time examTime,String timeFormat) {
	       SimpleDateFormat  formatter = new SimpleDateFormat(timeFormat);
	       String newTime = formatter.format(examTime);
	       
	       return newTime;
		}

	public static String convertDate_ToSpecific_DateFormat(Date examDate,String dateFormat) {
       SimpleDateFormat  formatter = new SimpleDateFormat(dateFormat);
       String newDate = formatter.format(examDate);
       
       return newDate;
	}
	
	public static String convertDateInString_ToOtherFormat_DateInString(String oldDate,String oldDateFormat,String newDateFormat) {
		
		try {
		
	       SimpleDateFormat  oldFormatter = new SimpleDateFormat(oldDateFormat);
	       SimpleDateFormat  newFormatter = new SimpleDateFormat(newDateFormat);
	       
	       Date date = oldFormatter.parse(oldDate);
	       String newDate = newFormatter.format(date);
	       
	       return newDate;
	       
		} catch (ParseException e) {
			e.printStackTrace();
			return oldDate;
		}
		
		
		}

}
