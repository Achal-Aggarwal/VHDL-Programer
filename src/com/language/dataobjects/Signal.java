package com.language.dataobjects;
import com.language.datatypes.*;
public class Signal {
	public String name;
	DataType data_type;
	public Signal(){
		this.name = null;
		data_type = null;
	}
	public Signal(String name){
		this.name = name;
		data_type = new DataType();
	}
	public Signal(String name, String data_type){
		this.name = name;
		this.data_type = new DataType(data_type);
	}
	public Signal(String name, DataType data_type){
		this.name = name;
		this.data_type = data_type;
	}
	public void writeToDB(){
		
	}
}