package com.sonny.demo.DataAndTime;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

// Refer to http://www.ewdna.com/2009/01/javadatecalendardateformatsimpledatefor.html
public class DateDemo {

	public static void main(String[] args) {
//		DateToTWDate();
//		getYearOfDateString();
//		betweenStartAndEndTime();
//		showStringToCalendar();
//		showStringToDate();
		showNowDate();
	}

	public static void DateToTWDate(){
		String dateString = "2021-03-08 05:08:06";
		try {
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dfs.parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;	//Jan = 0, dec = 11
			int day = calendar.get(Calendar.DATE);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int min = calendar.get(Calendar.MINUTE);
			int sec = calendar.get(Calendar.SECOND);

			int twYear = year - 1911;

			String monthString = Integer.toString(month);
			if (month<10){
				monthString = "0" + monthString;
			}

			String dayString = Integer.toString(day);
			if (day<10){
				dayString = "0" + day;
			}

			String hourString = Integer.toString(hour);
			if (hour<10){
				hourString = "0" + hour;
			}

			String minString = Integer.toString(min);
			if (min<10){
				minString = "0" + min;
			}

			String secString = Integer.toString(sec);
			if (sec<10){
				secString = "0" + sec;
			}

			String twDate = twYear + "/" +monthString + "/" + dayString + " " + hourString + ":" + minString +":" + secString;

			System.out.println("西元: " + dateString);
			System.out.println("民國: " + twDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void getYearOfDateString(){
		String dateString = "2021-07-27 15:28:38";

		try {
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dfs.parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			System.out.println("Year: " + calendar.get(Calendar.YEAR));
			System.out.println("Month: " + (calendar.get(Calendar.MONTH)+1));	//Jan = 0, dec = 11
			System.out.println("Day: " + calendar.get(Calendar.DATE));
			System.out.println("Hour: " + calendar.get(Calendar.HOUR_OF_DAY));
			System.out.println("Min: " + calendar.get(Calendar.MINUTE));
			System.out.println("Sec: " + calendar.get(Calendar.SECOND));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void betweenStartAndEndTime(){
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date begin = dfs.parse("2020-08-02 12:00:00");
			Date end = dfs.parse("2020-08-12 13:01:02");
			long between=(end.getTime()-begin.getTime())/1000;  //除以1000是為了轉換成秒

			long day=between/(24*60*60);
			long hour=(between/(60*60)-day*24);
			long min=((between/(60))-day*24*60-hour*60);
			long second=(between -day*24*60*60-hour*60*60-min*60);

			System.out.println(""+ day +"天"+ hour +"小時"+ min +"分"+ second +"秒");

		} catch (ParseException e) {
			e.printStackTrace();
		}
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
//		String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";	// ISO-8601 format
		String DATEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMAT);
//		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//	    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//	    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		String nowTime = simpleDateFormat.format(new Date());

		System.out.println(nowTime);

		SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);

		try {
			System.out.println("now Time=" + dateFormat.parse(nowTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
