package com.jackson.annotation.tests.polymorphism.models;

import java.util.Objects;
import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jackson.annotation.tests.polymorphism.commons.DBUtil;
import com.jackson.annotation.tests.polymorphism.commons.TableConstant;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Field 
{
	H_WHSE_ID			(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_WHSE_ID),
	H_BLDG_ID			(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_BLDG_ID),
	H_COMPANY_NO		(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_COMPANY_NO),
	H_ID				(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_ID),
	H_TYPE				(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_TYPE),
	H_LINE_ITEM_COUNT	(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_LINE_ITEM_COUNT),
	H_ORDER_DATE		(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_ORDER_DATE, DBUtil::applyDateFunction),
	H_AMOUNT			(TableConstant.TABLE_NAME_ORDER_HEADER, TableConstant.TABLE_ALIAS_ORDER_HEADER, TableConstant.COLUMN_NAME_AMOUNT);
	
	private String tableName;
	private String tableAlias;
	private String columnName;
	private Function<Object, Object> dbValueTransformer;
	
	private Field(String tableName, String tableAlias, String columnName)
	{
		this.tableName	= tableName;
		this.tableAlias	= tableAlias;
		this.columnName = columnName;
	}
	
	private Field(String tableName, String tableAlias, String columnName, Function<Object, Object> dbValueTransformer)
	{
		this(tableName, tableAlias, columnName);
		this.dbValueTransformer = dbValueTransformer;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public String getTableAlias() {
		return tableAlias;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public Object getDBTransformedValue(Object object)
	{
		return dbValueTransformer!=null ? dbValueTransformer.apply(object) : object;
	}
	
	@JsonCreator
	public static Field getFieldByCreator(Object object)
	{
		if(Objects.isNull(object))
		{
			return Field.H_WHSE_ID;
		}
		
		return Field.valueOf(String.valueOf(object).toUpperCase());
	}
}