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
//		compareDate();
//		compareDateBySec();
//		DateToTWDate();
		getYearOfDateString();
//		betweenStartAndEndTime();
//		showStringToCalendar();
//		showStringToDate();
//		showNowDate();
	}

	public static void compareDate(){
		String todayString = "2022-07-01 00:08:06";
		String startDateString = "2022-06-30 05:08:06";
		String EndDateString = "2022-07-03 05:08:06";
//		Date today;

		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
		try {
//			today = dfs.parse(dfs.format(new Date()));	// date -> string -> date
			Date today = dfs.parse(todayString);
			Date startDate = dfs.parse(startDateString);
			Date endDate = dfs.parse(EndDateString);

			System.out.println("Today: " + dfs.format(today));
			System.out.println("Start Date: " + dfs.format(startDate));
			System.out.println("End Date: " + dfs.format(endDate));

			System.out.println("-----------------------------");
			System.out.println("Is after (today > start date?): " + today.after(startDate));
			System.out.println("Is equals (today = start date?): " + today.equals(startDate));
			System.out.println(" today >= start date ? : " + greaterThanOrEqualTo(todayString, startDateString));

			System.out.println("-----------------------------");
			System.out.println("Is before (today < end date?): " + today.before(endDate));
			System.out.println("Is equals (today = end date?): " + today.equals(endDate));
			System.out.println(" today <= end date ? : " + lessThanOrEqualTo(todayString, EndDateString));

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * current Date >= compare date 2 ?
	 * */
	private static boolean greaterThanOrEqualTo(String currentDateString, String compareDateString){
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date currentDate = dfs.parse(currentDateString);
			Date compareDate = dfs.parse(compareDateString);

			if (currentDate.after(compareDate) || currentDate.equals(compareDate)){
				return true;
			}

		} catch (ParseException e) {
//			throw new RuntimeException(e);
		}

		return false;
	}

	/**
	 * current Date <= compare Date ?
	 * */
	private static boolean lessThanOrEqualTo(String currentDateString, String compareDateString){
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date currentDate = dfs.parse(currentDateString);
			Date compareDate = dfs.parse(compareDateString);

			if (currentDate.before(compareDate) || currentDate.equals(compareDate)){
				return true;
			}

		} catch (ParseException e) {
//			throw new RuntimeException(e);
		}

		return false;

	}

	/**
	 *  getTime() 的秒數是從 January 1, 1970, 00:00:00 GMT 算起
	 * */
	public static void compareDateBySec(){
		String todayString = "2022-07-01 00:08:30";
		String startDateString = "2022-06-30 05:08:59";
		String startEndString = "2022-07-02 12:08:19";

		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date today = dfs.parse(todayString);
			Date startDate = dfs.parse(startDateString);
			Date endDate = dfs.parse(startEndString);


			System.out.println("Today: " + dfs.format(today));
			System.out.println("Start Date: " + dfs.format(startDate));
			System.out.println("End Date: " + dfs.format(endDate));

			long todaySec = today.getTime();
			long starDateSec = startDate.getTime();
			long endDateSec = endDate.getTime();

			System.out.println("-----------------------------");
			System.out.println("("+ dfs.format(today) +") Today sec:" + todaySec);
			System.out.println("("+ dfs.format(startDate) +") Start Date Sec:" + starDateSec);
			System.out.println("("+ dfs.format(endDate) +") End Date Sec:" + endDateSec);

			System.out.println("Today >= start ? : " + (todaySec >= starDateSec));
			System.out.println("Today <= end ? : " + (todaySec <= endDateSec));

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
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
		String dateString = "2023-05-28 15:28:38";

		try {
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dfs.parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			System.out.println("Year: " + calendar.get(Calendar.YEAR));
			System.out.println("Month: " + (calendar.get(Calendar.MONTH)+1));	//Jan = 0, dec = 11
			System.out.println("Day: " + calendar.get(Calendar.DATE));
			System.out.println("Day of week : " + calendar.get(Calendar.DAY_OF_WEEK));	// 1: 星期日, 2: 星期一, 3: 星期二, 4: 星期三, 5: 星期四, 6: 星期五, 7: 星期六
			System.out.println("Weekday: " + getWeekOfDate(calendar));		// 星期幾
			System.out.println("Hour: " + calendar.get(Calendar.HOUR_OF_DAY));
			System.out.println("Min: " + calendar.get(Calendar.MINUTE));
			System.out.println("Sec: " + calendar.get(Calendar.SECOND));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	public static String getWeekOfDate(Calendar calendar) {
		String[] weekDays = { "日", "一", "二", "三", "四", "五", "六" };
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(dt);
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
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
