package com.jackson.annotation.tests;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils 
{
	public static ObjectMapper getMapper()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper;
	}
	
	public static void printModel(Object user, ObjectMapper mapper) 
	{
		try
		{
			String result = mapper.writeValueAsString(user);
			System.out.println(result);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	
	public static <T> T getInstance(String jsonString, Class<T> type, ObjectMapper mapper)
	{
		try
		{
			return mapper.readValue(jsonString, type);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
