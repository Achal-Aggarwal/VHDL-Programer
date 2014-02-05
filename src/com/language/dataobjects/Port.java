package com.language.dataobjects;

import com.language.datatypes.ArrayType;
import com.language.datatypes.DataType;

public class Port extends Signal {
	public String mode;
	Port(){
		super();
	}
	public Port(String name){
		super(name);
	}
	public Port(String name, DataType data_type, String mode){
		super(name,data_type);
		this.mode = mode;
	}
	public String toString(){
		String str=this.name + " : " + this.mode + " " + this.data_type.name;
		if(this.data_type instanceof ArrayType){
			ArrayType at = (ArrayType) this.data_type;
			str +=" RANGE ( "+ at.starting_index + " "+ at.indexing_scheme + " "+ at.ending_index + " );";
		}
		return str;
	}
}
