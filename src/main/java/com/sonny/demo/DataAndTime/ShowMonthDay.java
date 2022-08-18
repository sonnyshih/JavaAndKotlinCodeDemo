package com.sonny.demo.DataAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShowMonthDay {
    public static Map<Integer, String>  DAY = new HashMap<Integer, String>() {{
        put(1, "日");
        put(2, "一");
        put(3, "二");
        put(4, "三");
        put(5, "四");
        put(6, "五");
        put(7, "六");
    }};

    public static void main(String[] args) {
        showMonthCalendar();

//        useDateStringToShowDate();
//        nowTimeShowDate();
    }


    private static void useDateStringToShowDate(){
        String dateString = "2020-07-27";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
//            System.out.println("Original Date: " + dateString);
            date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DATE, 1);
            int month = calendar.get(Calendar.MONTH);

            while (calendar.get(Calendar.MONTH) == month) {
                // 1: 日, 2: 一, 3: 二 , 4: 三 , 5:四, 6: 五 , 7: 六:
                System.out.println("日期:" + sdf.format(calendar.getTime()) + " 星期 " + DAY.get(calendar.get(Calendar.DAY_OF_WEEK)) );

                calendar.add(Calendar.DATE, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static void nowTimeShowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//      System.out.println("Original Date: " + dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        int month = calendar.get(Calendar.MONTH);

        while (calendar.get(Calendar.MONTH) == month) {
            // 1: 日, 2: 一, 3: 二 , 4: 三 , 5:四, 6: 五 , 7: 六:
            System.out.println("日期:" + sdf.format(calendar.getTime()) + " 星期 " + DAY.get(calendar.get(Calendar.DAY_OF_WEEK)) );

            calendar.add(Calendar.DATE, 1);
        }

    }

    private static void showMonthCalendar() {
        String dateString = "2022-05-27";

        List<Map<String, String>> dayList = getMonthDayMap(dateString);


        // 當月第一天是星期幾
        Map<String, String> firstData = dayList.get(0);
        int firstDay = Integer.valueOf(firstData.get("DayNum")) ;
        System.out.println("當月第一天 -- day="+firstDay + "## 星期 " + DAY.get(firstDay));

        // 第一天星期幾，就把前面補滿空白星期 到星期日 (例: 第1天值是 3就是期星二，前面就要補2個空白日)
        for (int i=1; i< firstDay; i++){
            Map<String, String> entity = new HashMap<>();
            entity.put("Day", String.valueOf(i));
            entity.put("Date", "    xx    ");
            dayList.add(0, entity);
        }

        // 當月最後一天是星期幾
        int lastIndex = dayList.size() - 1;
        Map<String, String> lastData = dayList.get(lastIndex);
        int lastDay = Integer.valueOf(lastData.get("DayNum")) ;
        System.out.println("當月最後一天 -- day="+lastDay + "## 星期 " + DAY.get(lastDay));

        // 如果最後一天不是星期六時
        if (lastDay!=7) {
            // 最後一天星期幾，就把「後面」補滿空白星期 到星期六 (例: 最後1天值是 4就是期星三，「後面」就要補3個空白日)
            for (int i = lastDay+1; i <= 7; i++) {
                Map<String, String> entity = new HashMap<>();
                entity.put("Day", String.valueOf(i));
                entity.put("Date", "    xx    ");
                dayList.add(entity);
            }
        }

        System.out.println("size: " + dayList.size());

        // 需要多少週
        int weeks = (int)Math.ceil(dayList.size()/7);
        System.out.println("Total Weeks: " + weeks);

        System.out.println("|    週     |     日       |      一      |      二      |      三      |       四      |      五      |      六      |");
        int index = 0;
        for (int i=0; i<weeks; i++){

            System.out.print("   第 "+ (i+1) +" 週   ");

            for (int j=0; j<7; j++){
                Map<String, String> item = dayList.get(index);
                System.out.print("  "+ item.get("Date") +"   ");
                index++;
            }
            System.out.println("");

        }
    }

    private static List<Map<String, String>> getMonthDayMap(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        List<Map<String, String>> list =  new ArrayList<>();

        try {
//            System.out.println("Original Date: " + dateString);
            date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DATE, 1);
            int month = calendar.get(Calendar.MONTH);

            while (calendar.get(Calendar.MONTH) == month) {

                Map<String, String> map = new HashMap<>();
                map.put("DayNum", String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)));
                map.put("Date", sdf.format(calendar.getTime()));
                list.add(map);

                // 1: 日, 2: 一, 3: 二 , 4: 三 , 5:四, 6: 五 , 7: 六:
//                System.out.println("日期:" + sdf.format(calendar.getTime()) + " 星期 " + DAY.get(calendar.get(Calendar.DAY_OF_WEEK)) );

                calendar.add(Calendar.DATE, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }

}
