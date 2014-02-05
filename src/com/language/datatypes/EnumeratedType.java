package com.language.datatypes;

import java.util.ArrayList;

public class EnumeratedType extends DataType {
	ArrayList<String> identifier_list;
	EnumeratedType(){
		identifier_list = null;
	}
	EnumeratedType(String identifiers[]){
		for(int i=0;i<identifiers.length; i++)
			addIdentifier(identifiers[i]);
	}
	void addIdentifier(String identifier){
		identifier_list.add(identifier);
	}
	void addIdentifier(int index, String identifier){
		identifier_list.add(index,identifier);
	}
	String getIdentifier(int index){
		return identifier_list.get(index);
	}
	String[] getIdentifiers(){
		return (String[])identifier_list.toArray();
	}
}
