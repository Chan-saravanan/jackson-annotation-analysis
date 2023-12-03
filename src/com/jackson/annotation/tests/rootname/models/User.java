package com.jackson.annotation.tests.rootname.models;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="user")
public class User 
{
	private int id;
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}