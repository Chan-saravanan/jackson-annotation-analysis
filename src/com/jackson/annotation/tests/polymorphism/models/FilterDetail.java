package com.jackson.annotation.tests.polymorphism.models;

import java.util.HashSet;
import java.util.Set;

import com.jackson.annotation.tests.polymorphism.commons.Constants;

public class FilterDetail 
{
	private Set<TableDetail> tables;
	
	private String filter;
	
	public FilterDetail()
	{
		tables = new HashSet<>();
	}
	
	public void addDetail(String tableName, String tableAlias)
	{
		tables.add(this.new TableDetail(tableName, tableAlias));
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public String getFilter() {
		return filter;
	}
	
	public Set<TableDetail> getTables() {
		return tables;
	}
	
	public class TableDetail
	{
		private final String tableName;
		private final String tableAlias;
		private final String reference;
		
		private TableDetail(String tableName, String tableAlias)
		{
			this.tableName	= tableName;
			this.tableAlias = tableAlias;
			this.reference 	= tableName.concat(Constants.SEPARATOR_SPACE).concat(tableAlias);
		}
		
		public String getTableAlias() {
			return tableAlias;
		}
		public String getTableName() {
			return tableName;
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			TableDetail detail = TableDetail.class.cast(obj);
			
			return reference.equals(detail.reference); 
		}
		
		@Override
		public int hashCode() 
		{
			return reference.hashCode();
		}

		@Override
		public String toString() {
			return reference;
		}
	}

	@Override
	public String toString() {
		return "FilterDetail [tables=" + tables + ", filter=" + filter + "]";
	}	
}