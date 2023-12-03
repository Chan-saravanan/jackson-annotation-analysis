package com.jackson.annotation.tests.polymorphism.commons;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.jackson.annotation.tests.polymorphism.models.values.Value;

public class CommonPredicates
{
	public static final BiPredicate<Value<Object>, Class<?>> CONDITION_FILTER_TYPE 			= (value, _type)-> value.getClass() == _type;
	
	public static final Predicate<Object>	IS_STRING_TYPE									= (value)-> value.getClass() == String.class;
	public static final Predicate<Object>	IS_NUMBER_TYPE									= (value)-> value instanceof Number;
	public static final Predicate<Object>	IS_INTEGER_TYPE									= (value)-> value.getClass() == Integer.class;
	public static final Predicate<Object>	IS_LONG_TYPE									= (value)-> value.getClass() == Long.class;
	public static final Predicate<Object>	IS_DOUBLE_TYPE									= (value)-> value.getClass() == Double.class;
	public static final Predicate<Object>	IS_Float_TYPE									= (value)-> value.getClass() == Float.class;
	public static final Predicate<Object>	IS_BOOLEAN_TYPE									= (value)-> value.getClass() == Boolean.class;
	
	public static final Predicate<Object>	IS_PRIMITIVE_TYPE								= IS_STRING_TYPE.or(IS_NUMBER_TYPE);
	public static final Predicate<Object>	IS_VECTOR_TYPE									= (value)-> List.class.isAssignableFrom(value.getClass());
	
	public static final Predicate<Object> IS_SCALAR_TYPE_VALUE						= (value)-> IS_PRIMITIVE_TYPE.test(value);
	public static final Predicate<Object> IS_VECTOR_TYPE_VALUE						= (value)-> IS_VECTOR_TYPE.test(value);
	public static final Predicate<Object> IS_VECTOR_TYPE_AND_WITH_2_AS_LENGHT_VALUE	= (value)-> IS_VECTOR_TYPE.test(value) && List.class.cast(value).size() == 2;
}
