package com.jackson.annotation.tests.polymorphism.models.values;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public interface Value<T> 
{
	Object getValue();
	
	@JsonCreator
	public static <X> Value<X> getValueByCreator(X o)
	{
		System.out.println("Inside getValueByCreator"+o);
		
		return (o instanceof List) ? new VectorValue<>((List<X>) o) : new ScalarValue<>(o);
	}
}