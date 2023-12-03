package com.jackson.annotation.tests.polymorphism.models;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jackson.annotation.tests.polymorphism.commons.CommonPredicates;
import com.jackson.annotation.tests.polymorphism.commons.CommonUtil;
import com.jackson.annotation.tests.polymorphism.commons.Constants;
import com.jackson.annotation.tests.polymorphism.models.values.Value;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Operator 
{
	EQUAL			(Constants.OPERATOR_EQUAL, 			CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil::getValue),
	NOT_EQUAL		(Constants.OPERATOR_NOT_EQUAL,		CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil::getValue),
	LESS_THAN		(Constants.OPERATOR_LESS_THAN,		CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil::getValue),
	LESS_EQUAL		(Constants.OPERATOR_LESS_EQUAL,		CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil::getValue),
	GREATER_THAN	(Constants.OPERATOR_GREATER_THAN,	CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil::getValue),
	GREATER_EQUAL	(Constants.OPERATOR_GREATER_EQUAL,	CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil::getValue),
	STARTS_WITH		(Constants.OPERATOR_LIKE,			CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil.GET_STARTS_WITH_FORMAT),
	ENDS_WITH		(Constants.OPERATOR_LIKE,			CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil.GET_ENDS_WITH_FORMAT),
	LIKE			(Constants.OPERATOR_LIKE,			CommonPredicates.IS_SCALAR_TYPE_VALUE,						CommonUtil.GET_LIKE_FORMAT),
	IN				(Constants.OPERATOR_IN,				CommonPredicates.IS_VECTOR_TYPE_VALUE,						CommonUtil::getListValue),
	NOT_IN			(Constants.OPERATOR_NOT_IN,			CommonPredicates.IS_VECTOR_TYPE_VALUE,						CommonUtil::getListValue),
	BETWEEN			(Constants.OPERATOR_BETWEEN,		CommonPredicates.IS_VECTOR_TYPE_AND_WITH_2_AS_LENGHT_VALUE, CommonUtil::getBetweenValue);
	
	private String operator;
	private Predicate<Object> typeTester;
	private BiFunction<Object, Function<Object, Object>,  Object> valueTransformer;
	
	private <T> Operator(String operator, Predicate<Object> typeTester, BiFunction<Object, Function<Object, Object>,  Object> valueTransformer)
	{
		this.operator			= operator;
		this.typeTester			= typeTester;
		this.valueTransformer	= valueTransformer;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public Object applyTransformer(Object value, Function<Object, Object> dbValueTransformer) 
	{
		if(typeTester.test(value))
		{
			return Objects.nonNull(valueTransformer) ? valueTransformer.apply(value, dbValueTransformer) : value;
		}
		
		throw new RuntimeException();
	}
	
	@JsonCreator
	public static Operator getOperator(Object object)
	{
		if(Objects.isNull(object))
		{
			return Operator.EQUAL;
		}
		
		return Operator.valueOf(String.valueOf(object).toUpperCase());
	}
}
