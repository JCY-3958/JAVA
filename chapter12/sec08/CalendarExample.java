package chapter12.sec08;

import java.util.*;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		
		String strweek = null;
		
		switch(week) {
		case Calendar.MONDAY : strweek = "월"; break;
		case Calendar.TUESDAY : strweek = "화"; break;
		case Calendar.WEDNESDAY : strweek = "수"; break;
		case Calendar.THURSDAY : strweek = "목"; break;
		case Calendar.FRIDAY : strweek = "금"; break;
		case Calendar.SATURDAY : strweek = "토"; break;
		default: strweek = "일";
		}
		
		int ampm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if(ampm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일 ");
		System.out.print(strweek + "요일 ");
		System.out.println(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.print(second + "초 ");
	}

}
