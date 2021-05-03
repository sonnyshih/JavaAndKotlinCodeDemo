package com.sonny.demo.DataAndTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStamp {
	public static void main(String[] args) {

		getAdd30DayString();
//		getCurrentTimeByTimeStamp();
	}

	private static void getAdd30DayString(){
		String dateString = "2021050314365778";
		int day = 30;
		String newDateString = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		Date date = null;
		try {
			date = sdf.parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, day);

			Timestamp ts = new Timestamp(calendar.getTimeInMillis());
			newDateString = sdf.format(ts);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("   dateString=" + dateString);
		System.out.println("newDateString=" + newDateString);
	}

	private static void getCurrentTimeByTimeStamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		System.out.println("currentTimeMillis=" + System.currentTimeMillis());
		System.out.println("Timestamp=" + ts);

		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			// 1
			tsStr = sdf.format(ts);
			System.out.println(tsStr);

			// 2
			tsStr = ts.toString();
			System.out.println(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
