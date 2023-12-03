package com.jackson.annotation.tests.polymorphism.models.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jackson.annotation.tests.polymorphism.commons.Constants;
import com.jackson.annotation.tests.polymorphism.models.Field;
import com.jackson.annotation.tests.polymorphism.models.FilterDetail;
import com.jackson.annotation.tests.polymorphism.models.Operator;
import com.jackson.annotation.tests.polymorphism.models.values.Value;

public class SimpleFilter<T> implements Filter
{
	@JsonProperty(Constants.JSON_FIELD_FIELD)
	private Field field;
	
	@JsonProperty(Constants.JSON_FIELD_OPERATOR)
	private Operator operator;
	
	@JsonProperty(Constants.JSON_FIELD_VALUE)
	private Value<T> value;
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Value<T> getValue() {
		return value;
	}
	public void setValue(Value<T> value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "SimpleFilter [field=" + field + ", operator=" + operator + ", value=" + value + "]";
	}
	
	@Override
	public String getFilter(FilterDetail filterDetail) 
	{
		filterDetail.addDetail(field.getTableName(), field.getTableAlias());
		
		Object object			= value.getValue();
		Object transformedValue	= operator.applyTransformer(object, field::getDBTransformedValue);
		String _operator		= operator.getOperator();
		
		return field.getColumnName()+" "+_operator+" "+transformedValue;
	}
}
