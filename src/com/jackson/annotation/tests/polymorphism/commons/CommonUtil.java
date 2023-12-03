package com.jackson.annotation.tests.polymorphism.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.jackson.annotation.tests.polymorphism.models.values.Value;

public class CommonUtil 
{
	public static Object getValue(Object value, Function<Object, Object> dbValueTransformer)
	{
		return value;
	}
	
	public static Object getBetweenValue(Value<Object> valueObject, Function<Object, Object> dbValueTransformer)
	{
		return valueObject.getValue();
	}
	
	public static List<Object> getListValue(Object value, Function<Object, Object> dbValueTransformer)
	{
		List<Object> list =  List.class.cast(value);
		
		List<Object> newList = new ArrayList<>();
		
		list.stream().map(dbValueTransformer::apply).forEach(newList::add);
		
		return newList;
	}
	
	public static Object getBetweenValue(Object value, Function<Object, Object> dbValueTransformer)
	{
		return DBUtil.getBetweenVale(value);
	}
	
	public static final BiFunction<Object, Function<Object, Object>, Object> GET_LIKE_FORMAT		=	(value, dbValueTransformer)-> String.format(Constants.LIKE_FORMAT, 			dbValueTransformer.apply(value));
	public static final BiFunction<Object, Function<Object, Object>, Object> GET_STARTS_WITH_FORMAT	=	(value, dbValueTransformer)-> String.format(Constants.STARTS_WITH_FORMAT,	dbValueTransformer.apply(value));
	public static final BiFunction<Object, Function<Object, Object>, Object> GET_ENDS_WITH_FORMAT	=	(value, dbValueTransformer)-> String.format(Constants.ENDS_WITH_FORMAT,		dbValueTransformer.apply(value));
}
