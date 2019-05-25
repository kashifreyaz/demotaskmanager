package com.demo.taskmanager.util;

import java.util.List;

public class QueryUtils {
	public static String getInQueryAppender(List<String> list) {
		StringBuilder query = new StringBuilder();
		query.append(" (");
		for(int i=0;i<list.size();i++) {
			query.append(" '"+list.get(i)+"'");
			if(i<list.size()-1) {
				query.append(", ");
			}
		}
		query.append(" )");
		return query.toString();
	}
}
