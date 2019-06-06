package com.sonny.demo.DataAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Refer to http://www.ewdna.com/2009/01/javadatecalendardateformatsimpledatefor.html
public class DateDemo {

	public static void main(String[] args) {
		String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";	// ISO-8601 format
//		String DATEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
		
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);
	    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//	    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//	    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
	    String utcTime = simpleDateFormat.format(new Date());
		
	    System.out.println(utcTime);
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
	    
	    try {
			System.out.println(dateFormat.parse(utcTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
