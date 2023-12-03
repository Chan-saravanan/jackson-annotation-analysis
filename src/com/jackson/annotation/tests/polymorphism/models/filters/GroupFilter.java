package com.jackson.annotation.tests.polymorphism.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jackson.annotation.tests.polymorphism.commons.Constants;
import com.jackson.annotation.tests.polymorphism.models.Connective;

public class GroupFilter implements Filter
{
	@JsonProperty(Constants.JSON_FIELD_CONNECTIVE)
	private Connective connective;
	@JsonProperty(Constants.JSON_FIELD_GROUPS)
	private List<Filter> filters;
	
	public void setConnective(Connective connective) {
		this.connective = connective;
	}
	public Connective getConnective() {
		return connective;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	public List<Filter> getFilters() {
		return filters;
	}
	
	@Override
	public String getFilter() 
	{
		String delimiter = " ".concat(getConnective().getConnective()).concat(" ");
		
		return filters.stream().map(Filter::getFilter).map(_value-> "(".concat(_value).concat(")")).collect(Collectors.joining(delimiter, "(", ")"));
	}
}
