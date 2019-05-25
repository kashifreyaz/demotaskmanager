package com.demo.taskmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

	static String pattern = "yyyy-MM-dd";
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public static Date getDate(String date) {
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, String> getFromAndToDateFromDaySpan(Integer days){
		Map<String, String> resultData = new HashMap<String, String>();
		String currentDate = simpleDateFormat.format(new Date());
        Calendar cal = Calendar.getInstance();
		if(days==0) {
			resultData.put("date", currentDate);
		}else {
			cal.add(Calendar.DATE, days);
			Date range = cal.getTime();
			String finalDate = simpleDateFormat.format(range);
			if (days>0) {
				resultData.put("fromDate", currentDate);
				resultData.put("toDate", finalDate);
			}else {
				resultData.put("fromDate", finalDate);
				resultData.put("toDate", currentDate);
			}
		}
		return resultData;
	}
}
