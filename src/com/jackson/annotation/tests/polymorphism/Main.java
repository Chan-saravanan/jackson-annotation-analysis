package com.jackson.annotation.tests.polymorphism;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.annotation.tests.Utils;
import com.jackson.annotation.tests.polymorphism.commons.Constants;
import com.jackson.annotation.tests.polymorphism.models.FilterDetail;
import com.jackson.annotation.tests.polymorphism.models.FilterObject;

public class Main 
{
	public static void main(String[] args) 
	{
		String json = "{\"filter\":{\"field\":\"h_id\",\"operator\":\"equal\",\"value\":\"10000\"}}";
		json = "{\"filter\": {\"groups\": [{\"groups\": [{\"field\": \"h_whse_id\",\"operator\": \"equal\",\"value\": \"CN\"},{\"field\": \"h_bldg_id\",\"operator\": \"equal\",\"value\": \"B1\"},{\"field\": \"h_company_no\",\"operator\": \"equal\",\"value\": \"C1\"}],\"connective\": \"and\"},{\"field\": \"h_type\",\"operator\": \"equal\",\"value\": \"PCN\"}],\"connective\": \"and\"}}";
		json = "{\"filter\": {\"groups\": [{\"groups\": [{\"field\": \"h_whse_id\",\"operator\": \"equal\",\"value\": \"CN\"},{\"field\": \"h_bldg_id\",\"operator\": \"equal\",\"value\": \"B1\"},{\"field\": \"h_company_no\",\"operator\": \"equal\",\"value\": \"C1\"}],\"connective\": \"and\"},{\"groups\": [{\"field\": \"h_whse_id\",\"operator\": \"equal\",\"value\": \"US\"},{\"field\": \"h_bldg_id\",\"operator\": \"equal\",\"value\": \"B1\"},{\"field\": \"h_type\",\"operator\": \"in\",\"value\": [\"P\",\"C\",\"N\"]},{\"field\": \"h_order_date\",\"operator\": \"greater_than\",\"value\": \"02/12/2023\"}],\"connective\": \"and\"},{\"field\": \"h_line_item_count\",\"operator\": \"greater_than\",\"value\": \"10000\"}],\"connective\": \"or\"}}";
		json = "{\"filter\": {\"groups\": [{\"groups\": [{\"field\": \"h_whse_id\",\"operator\": \"like\",\"value\": \"test\"},{\"field\": \"h_bldg_id\",\"operator\": \"starts_with\",\"value\": \"T1\"},{\"field\": \"h_company_no\",\"operator\": \"ends_with\",\"value\": \"T2\"}],\"connective\": \"and\"},{\"field\": \"h_order_date\",\"operator\": \"between\",\"value\": [\"01/01/2023\", \"1/12/2023\"]}],\"connective\": \"and\"}}";
		
		ObjectMapper mapper = Utils.getMapper();
		
		FilterObject filter = Utils.getInstance(json, FilterObject.class, mapper);
		
		FilterDetail detail = filter.getFilterQuery();
		
		System.out.println("Filter Query : "+detail.getFilter());
		System.out.println("Involved tables : "+detail.getTables());
	}
}
