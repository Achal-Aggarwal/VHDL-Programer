package com.language.dataobjects;

import com.language.datatypes.ArrayType;
import com.language.datatypes.DataType;

public class Generic {
	public String name;
	DataType data_type;
	public Generic(){
		this.name = null;
		data_type = null;
	}
	public Generic(String name){
		this.name = name;
		data_type = new DataType();
	}
	public Generic(String name, String data_type){
		this.name = name;
		this.data_type = new DataType(data_type);
	}
	public Generic(String name, DataType data_type){
		this.name = name;
		this.data_type = data_type;
	}
	public void writeToDB(){
		
	}
	public String toString(){
		String str=this.name + " : " + this.data_type.name;
		if(this.data_type instanceof ArrayType){
			ArrayType at = (ArrayType) this.data_type;
			str +=" RANGE ( "+ at.starting_index + " "+ at.indexing_scheme + " "+ at.ending_index + " );";
		}
		return str;
	}
}
