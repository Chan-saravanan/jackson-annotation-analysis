package com.jackson.annotation.tests.polymorphism.models.filters;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.jackson.annotation.tests.polymorphism.models.FilterDetail;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({ @Type(SimpleFilter.class), @Type(GroupFilter.class) })
public interface Filter 
{
	String getFilter(FilterDetail filterDetail);
}