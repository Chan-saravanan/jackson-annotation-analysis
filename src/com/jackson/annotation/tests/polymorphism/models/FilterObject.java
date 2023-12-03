package com.jackson.annotation.tests.polymorphism.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jackson.annotation.tests.polymorphism.commons.Constants;
import com.jackson.annotation.tests.polymorphism.models.filters.Filter;

public class FilterObject 
{
	@JsonProperty(Constants.JSON_FIELD_FILTER)
	private Filter conditionalFilter;
	
	public void setConditionalFilter(Filter conditionalFilter) {
		this.conditionalFilter = conditionalFilter;
	}
	public Filter getConditionalFilter() {
		return conditionalFilter;
	}
	
	public String getFilterQuery()
	{
		return conditionalFilter.getFilter();
	}
}