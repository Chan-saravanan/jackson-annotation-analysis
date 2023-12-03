package com.jackson.annotation.tests.polymorphism.models.values;

import java.util.List;

public class VectorValue<T> implements Value<T>
{
	private List<T> vectorValues;
	
	public VectorValue(List<T> vectorValues)
	{
		this.vectorValues = vectorValues;
	}
	
	public void setVectorValues(List<T> vectorValues) {
		this.vectorValues = vectorValues;
	}
	public List<T> getVectorValues() {
		return vectorValues;
	}
	
	@Override
	public List<T> getValue() 
	{
		return vectorValues;
	}
}
