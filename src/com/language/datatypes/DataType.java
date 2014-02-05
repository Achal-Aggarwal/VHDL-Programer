package com.language.datatypes;

public class DataType {
	public String name;
	public String type;
	public DataType(){	
		this.name = null;
		this.type = null;
	}
	public DataType(String name){
		this.name = name;
	}
	public DataType(String name,String type){
		this.name = name;
		this.type = type;
	}
}
