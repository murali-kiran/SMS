package com.sumadga.sms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

	public static Date getStringToDate(String dateStr) {

		DateFormat fomatter = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date date = fomatter.parse(dateStr);
			System.out.println("Time : " + date.getTime());
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

}
