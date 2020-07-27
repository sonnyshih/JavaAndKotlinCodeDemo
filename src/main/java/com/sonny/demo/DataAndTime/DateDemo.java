package com.sonny.demo.DataAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

// Refer to http://www.ewdna.com/2009/01/javadatecalendardateformatsimpledatefor.html
public class DateDemo {

	public static void main(String[] args) {
		showStringToCalendar();
//		showStringToDate();
//		showNowDate();
	}

	public static void showStringToCalendar(){
		int seconds = 5;
		String dateString = "2020-07-27 15:28:38";

		//設定日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//進行轉換
		Date date = null;

		try {
			System.out.println("Original Date: " + dateString);
			date = sdf.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.SECOND, seconds);

			Date newDate = cal.getTime();
			System.out.println("Plus 5 seconds: " + sdf.format(newDate));

			if (newDate.after(date)) {
				System.out.println("newDate is larger.");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

	public static void showStringToDate(){
		String dateString = "2020-07-27 15:28:38";
		//設定日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//進行轉換
		Date date = null;

		try {
			date = sdf.parse(dateString);
			System.out.println("String TO Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void showNowDate(){
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
			System.out.println("utcTime=" + dateFormat.parse(utcTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
