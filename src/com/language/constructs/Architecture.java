package com.language.constructs;

public class Architecture {
	public String name=null;
	public String entity_name=null;
	public Architecture(){}
	public Architecture(String name, String ename){
		this.name = name;
		this.entity_name = ename;
	}
	public String toString(){
		String tab = "     ";
		String str="ARCHITECTURE " + name + " OF " + entity_name + " IS \n"
				+ tab + "--declaration statements\n"
				+ "BEGIN\n"
				+ tab + "--concurrent statements\n"
				+ "END ARCHITECTURE " + name +";";
		return str;
	}
}
