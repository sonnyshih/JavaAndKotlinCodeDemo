package com.sonny.demo.DataAndTime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarAndSetTimeZoneDemo {

	public static void main(String[] args) {

		/* ####################################### */
		/* ##### Current Calendar Data Start ##### */
		/* ####################################### */
		System.out.println("/* ############################### */");
		System.out.println("/* ##### Calendar Demo Start ##### */");
		System.out.println("/* ############################### */");
		Calendar calendar = Calendar.getInstance();

		/* ##################################### */
		/* ##### Show Time Zone Data Start ##### */
		/* ##################################### */
		TimeZone nowTimeZone = calendar.getTimeZone();

		// Show time zone all data
		System.out.println("Now time zone all data = " + nowTimeZone);

		// Show the display name
		System.out.println("Now time zone - display name = "
				+ nowTimeZone.getDisplayName());

		// Show the id
		System.out.println("Now time zone - id = " + nowTimeZone.getID());

		/* ################################### */
		/* ##### Show Time Zone Data End ##### */
		/* ################################### */

		// Show the minute of now time
		System.out.println("calendar MINUTE =" + calendar.get(Calendar.MINUTE));

		// set minute to be 5: Ex: xx:05
		calendar.set(Calendar.MINUTE, 5);
		System.out.println("calendar set MINUTE ="
				+ calendar.get(Calendar.MINUTE));

		// show the hour of now time (Display 24 hours type)
		System.out.println("calendar HOUR_OF_DAY ="
				+ calendar.get(Calendar.HOUR_OF_DAY));

		// more 1 hour than now time
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		System.out.println("calendar HOUR_OF_DAY ="
				+ calendar.get(Calendar.HOUR_OF_DAY));

		System.out.println("calendar getTimeInMillis ="
				+ calendar.getTimeInMillis());

		System.out.println("/* ############################# */");
		System.out.println("/* ##### Calendar Demo End ##### */");
		System.out.println("/* ############################# */");

		/* ##################################### */
		/* ##### Current Calendar Data End ##### */
		/* ##################################### */

		/* ###################################### */
		/* ##### Assign the time zone Start ##### */
		/* ###################################### */
		System.out.println("/* ################################################# */");
		System.out.println("/* ##### Assign the time zone of Calendar Demo ##### */");
		System.out.println("/* ################################################# */");

		// Set the time zone
		// TimeZone timeZone = TimeZone.getTimeZone("PDT");
		// TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Taipei");
		Calendar gregorianCalendar = new GregorianCalendar(timeZone);

		int year = gregorianCalendar.get(Calendar.YEAR);
		int month = gregorianCalendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int day = gregorianCalendar.get(Calendar.DATE);
		int hour = gregorianCalendar.get(Calendar.HOUR); // 12 hour clock
		// gregorianCalendar.set(Calendar.HOUR_OF_DAY, -15);
		int hourOfDay = gregorianCalendar.get(Calendar.HOUR_OF_DAY); // 24 hour
																		// clock
		int minute = gregorianCalendar.get(Calendar.MINUTE);
		int second = gregorianCalendar.get(Calendar.SECOND);
		int millisecond = gregorianCalendar.get(Calendar.MILLISECOND);

		System.out.println("year = " + year + " month = " + month + " day = "
				+ day);
		System.out.println(" hour = " + hourOfDay + " minute = " + minute
				+ " second = " + second + " millisecond = " + millisecond);
		
		System.out.println("gregorianCalendar getTimeInMillis ="
				+ gregorianCalendar.getTimeInMillis());
		
		System.out.println("/* ##################################################### */");
		System.out.println("/* ##### Assign the time zone of Calendar Demo End ##### */");
		System.out.println("/* ##################################################### */");

		/* #################################### */
		/* ##### Assign the time zone End ##### */
		/* #################################### */

	}

}
