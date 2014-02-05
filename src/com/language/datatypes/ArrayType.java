package com.language.datatypes;

public class ArrayType extends DataType{
	public DataType datatype;
	public String indexing_scheme;
	public String starting_index, ending_index;
	public ArrayType(){
		this.indexing_scheme = null;
		this.starting_index = null;
		this.ending_index = null;
		this.datatype = null;
	}
	public ArrayType(String indexing_scheme){
		this.indexing_scheme = indexing_scheme;
		this.starting_index = "0";
		this.ending_index = "0";
		this.datatype = null;
	}
	public ArrayType(String indexing_scheme, String starting_index, String ending_index){
		this.indexing_scheme = indexing_scheme;
		this.starting_index = starting_index;
		this.ending_index = ending_index;
	}
	public ArrayType(DataType datatype,String indexing_scheme, String starting_index, String ending_index){
		this.indexing_scheme = indexing_scheme;
		this.starting_index = starting_index;
		this.ending_index = ending_index;
		this.datatype = datatype;
	}
	void setIndexingScheme(int indexing_scheme){
		if(indexing_scheme==0)
			this.indexing_scheme = "DOWNTO";
		else
			this.indexing_scheme = "TO";
	}
	void setRange(String starting_index, String ending_index){
		this.starting_index = starting_index;
		this.ending_index = ending_index;
	}
	String[] getRange(){
		String range[] = {starting_index, ending_index};
		return range;
	}
}
