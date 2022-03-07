package com.sonny.demo.DataAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarAndSetTimeZoneDemo {

	public static void main(String[] args) {
//		showTimeString();
		plusMinusTime();
//		showNowTimeData();
//		showTimeZoneData();
//		settingTimeZone();
	}

	private static void showTimeString(){
		Calendar calendar = Calendar.getInstance();
//        String DATEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
		String DATEFORMAT = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);

		Date startDate = calendar.getTime();
		System.out.println("start Date="+startDate);
		String startDateString = simpleDateFormat.format(startDate);
		System.out.println("start date String="+startDateString);
	}

	private static void plusMinusTime(){
		Calendar calendar = Calendar.getInstance();
        String DATEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
//		String DATEFORMAT = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);

		Date startDate = calendar.getTime();
		System.out.println("start Date="+startDate);
		String startDateString = simpleDateFormat.format(startDate);
		System.out.println("start date String="+startDateString);

		System.out.println("============= ");

		calendar.add(Calendar.YEAR, 3);				// plus 3 years
		calendar.add(Calendar.MONTH, 3);				// plus 3 months
		calendar.add(Calendar.DATE, 5);				// plus 3 days
		calendar.add(Calendar.HOUR_OF_DAY, 2);		// plus 2 hours
		calendar.add(Calendar.MINUTE, 10);			// plus 10 minutes
		calendar.add(Calendar.SECOND, 2);			// plus 30 secs
		calendar.add(Calendar.MILLISECOND, 200);		// plus 200 millisecond


		Date endDate = calendar.getTime();
		System.out.println("end Date="+endDate);
		String endDateString = simpleDateFormat.format(endDate);
		System.out.println("end date String="+endDateString);

	}

	private static void showNowTimeData(){
		Calendar calendar = Calendar.getInstance();

		// Show the minute of now time
		System.out.println("年 =" + calendar.get(Calendar.YEAR));
		System.out.println("月 =" + calendar.get(Calendar.MONTH));	// 0: 1月, 1: 2月, 2: 3月...
		System.out.println("日 =" + calendar.get(Calendar.DATE));
		System.out.println("時 =" + calendar.get(Calendar.HOUR_OF_DAY));	// 24 hours
		System.out.println("分 =" + calendar.get(Calendar.MINUTE));
		System.out.println("秒 =" + calendar.get(Calendar.SECOND));
		System.out.println("毫秒 =" + calendar.get(Calendar.MILLISECOND));

//		System.out.println("calendar getTimeInMillis =" + calendar.getTimeInMillis());
	}

	private static void showTimeZoneData(){
		Calendar calendar = Calendar.getInstance();
		TimeZone nowTimeZone = calendar.getTimeZone();

		// Show time zone all data
		System.out.println("Now time zone all data = " + nowTimeZone);

		// Show the display name
		System.out.println("Now time zone - display name = " + nowTimeZone.getDisplayName());

		// Show the id
		System.out.println("Now time zone - id = " + nowTimeZone.getID());

	}

	private static void settingTimeZone(){
		// Set the time zone
		// TimeZone timeZone = TimeZone.getTimeZone("PDT");
		// TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Taipei");
		Calendar gregorianCalendar = new GregorianCalendar(timeZone);

		int year = gregorianCalendar.get(Calendar.YEAR);
		int month = gregorianCalendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int day = gregorianCalendar.get(Calendar.DATE);
		int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY); // 24 hour
		int minute = gregorianCalendar.get(Calendar.MINUTE);
		int second = gregorianCalendar.get(Calendar.SECOND);
		int millisecond = gregorianCalendar.get(Calendar.MILLISECOND);

		System.out.println("year = " + year + " month = " + month + " day = " + day);
		System.out.println(" hour = " + hour + " minute = " + minute + " second = " + second + " millisecond = " + millisecond);

//		System.out.println("gregorianCalendar getTimeInMillis =" + gregorianCalendar.getTimeInMillis());
	}

}
