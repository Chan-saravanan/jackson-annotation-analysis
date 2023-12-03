package com.jackson.annotation.tests.polymorphism.commons;

import java.util.List;

public class DBUtil 
{
	public static final String DATE_FORMAT			= "MM-DD-YYYY";
	public static final String TO_DATE_PATTERN		= "TO_DATE('%s','%s')";
	public static final String BETWEEN_PATTERN		= "%s AND %s";
	
	public static final Object applyDateFunction(Object value)
	{
		return String.format(TO_DATE_PATTERN, value, DATE_FORMAT); 
	}
	
	public static final String getBetweenVale(Object object)
	{
		List<String> dates = (List<String>) object;
		
		Object fromDate = applyDateFunction(dates.get(0));
		Object toDate	= applyDateFunction(dates.get(1));
		
		return String.format(BETWEEN_PATTERN, fromDate, toDate);
	}
}
