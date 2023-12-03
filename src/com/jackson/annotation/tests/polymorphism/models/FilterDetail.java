package com.jackson.annotation.tests.polymorphism.models;

import java.util.ArrayList;
import java.util.List;

public class FilterDetail 
{
	private List<String> tables;
	private String filter;
	
	public FilterDetail()
	{
		tables = new ArrayList<>();
	}
	
	public void setTables(List<String> tables) {
		this.tables = tables;
	}
	public List<String> getTables() {
		return tables;
	}
	public void addTable(String tableName)
	{
		tables.add(tableName);
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public String getFilter() {
		return filter;
	}
}