package com.language.constructs;
import java.util.ArrayList;

import com.language.dataobjects.Generic;
import com.language.dataobjects.Port;
import com.vhdlprogramer.DataBase;

public class Entity {
	public String name;
	ArrayList<Port> ports;
	ArrayList<Generic> generics;
	public Entity(){
		this.name = null;
		ports = new ArrayList<Port>();
		generics = new ArrayList<Generic>();
	}
	public Entity(String name){
		this.name = name;
		ports = new ArrayList<Port>();
		generics = new ArrayList<Generic>();
	}
	public Entity(String name, Port ports[]){
		this.name = name;
		for(int i=0;i<ports.length;i++)
			addPort(ports[i]);
	}

	public void addPort(Port port){
		ports.add(port);
	}
	public void addPorts(Port ports[]){
		for(int i=0;i<ports.length;i++)
			addPort(ports[i]);
	}
	public boolean removePort(String port_name){
		Port sgl;
		boolean item_found = false;
		for(int i=0;i<ports.size();i++){
			sgl = (Port) ports.get(i);
			if (sgl.name.equals(port_name)){
				item_found = ports.remove(i) != null;
				break;
			}
		}
		return item_found;
	}
	public void removeAllPorts(){
		for(int i=0;i<ports.size();i++){
				ports.remove(i); 
		}
	}
	public Port getPort(int index){
		return ports.get(index);
	}
	public Port[] getAllPorts(){
		return (Port[]) ports.toArray();
	}
	
	public void addGeneric(Generic generic){
		generics.add(generic);
	}
	public void addGenerics(Generic generics[]){
		for(int i=0;i<generics.length;i++)
			addGeneric(generics[i]);
	}
	public boolean removeGeneric(String generic_name){
		Generic sgl;
		boolean item_found = false;
		for(int i=0;i<generics.size();i++){
			sgl = (Generic) generics.get(i);
			if (sgl.name.equals(generic_name)){
				item_found = generics.remove(i) != null;
				break;
			}
		}
		return item_found;
	}
	public void removeAllGenerics(){
		for(int i=0;i<generics.size();i++){
			generics.remove(i); 
		}
	}
	public Generic getGeneric(int index){
		return generics.get(index);
	}
	public Port[] getAllGenerics(){
		return (Port[]) generics.toArray();
	}
	public void writeToDB(){
		DataBase db = new DataBase("user");
		db.setTable("entity");
		String cols[]={"name", "config_id"};
		String vals[]={this.name,"0"};
		String types[]={"varchar","int"};
		
		db.createConnection();
		db.insert(cols, vals, types);
		db.closeConnection();
		
	}
	public String toString(){
		String str="";
		String tab = "     ";
		str += "ENTITY " + name + " IS";
		
		if (generics.size() > 0){
			str += tab + "\nGENERIC (";
			Generic gen;
			for(int i=0;i<generics.size();i++){
				gen = (Generic) generics.get(i);
				str += "\n" + tab + gen.toString()+";";
			}
			str = str.substring(0, str.length() - 1) + "\n" + tab + ");";
		}
		
		if (ports.size() > 0){
			str += tab +tab+ "\nPORT (";
			Port sgl;
			for(int i=0;i<ports.size();i++){
				sgl = (Port) ports.get(i);
				str += "\n" + tab +tab + sgl.toString()+";";
			}
			str = str.substring(0, str.length() - 1) + "\n" + tab + ");";
		}
		str += "\nEND ENTITY " + name + " ;";
		return str;
	}
	
}
