package com.jackson.annotation.tests.rootname;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jackson.annotation.tests.Utils;
import com.jackson.annotation.tests.rootname.models.User;

public class Main 
{
	public static void main(String[] args) 
	{
		User user = new User();
		
		user.setId(100);
		user.setName("Chanjay");
		
		ObjectMapper mapper = new ObjectMapper();
		
		Utils.printModel(user, mapper);
		
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		Utils.printModel(user, mapper);
		
		String string = "{\"user\":{\"id\":200,\"name\":\"Chanjay1\"}}";
		
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		user = Utils.getInstance(string, User.class, mapper);
		
		System.out.println(user);
	}
}
