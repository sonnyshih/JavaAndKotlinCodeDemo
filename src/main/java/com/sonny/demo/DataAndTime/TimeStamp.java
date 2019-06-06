package com.sonny.demo.DataAndTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeStamp {
	public static void main(String[] args) {

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
