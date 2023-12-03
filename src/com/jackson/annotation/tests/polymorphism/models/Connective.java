package com.jackson.annotation.tests.polymorphism.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jackson.annotation.tests.polymorphism.commons.Constants;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Connective 
{
	OR(Constants.CONNECTIVE_OR),
	AND(Constants.CONNECTIVE_AND);
	
	private String connective;
	
	private Connective(String connective)
	{
		this.connective = connective;
	}
	
	public String getConnective() {
		return connective;
	}
	
	@JsonCreator
	public static Connective getConnective(Object object)
	{
		if(Objects.isNull(object))
		{
			return Connective.OR;
		}
		
		return Connective.valueOf(String.valueOf(object).toUpperCase());
	}
}