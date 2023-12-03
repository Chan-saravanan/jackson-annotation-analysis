package com.jackson.annotation.tests.polymorphism.models.values;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ScalarValue<T> implements Value
{
	private T scalarValue;
	
	@JsonCreator
	public ScalarValue(T scalarValue)
	{
		this.scalarValue = scalarValue;
	}
	
	public void setScalarValue(T scalarValue) {
		this.scalarValue = scalarValue;
	}
	
	public T getScalarValue() {
		return scalarValue;
	}
	
	public T getValue() 
	{
		return scalarValue;
	}
}