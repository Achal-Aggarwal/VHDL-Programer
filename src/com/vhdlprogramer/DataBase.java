package com.vhdlprogramer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	String dbURL = "jdbc:derby:";
	String database_name = null;
    String table_name = null;
    // jdbc Connection
    private Connection conn = null;
    private Statement stmt = null;
    ResultSet results=null;
    ResultSetMetaData results_meta_data = null;
    public DataBase(String database_name) {
    	setDataBase(database_name);
	}
    public void setDataBase(String database_name){
    	this.database_name = database_name;
    	dbURL += this.database_name;
    }
    public String getDataBase(){
    	return this.database_name;
    }
    public void setTable(String table_name){
    	this.table_name = table_name;
    }
    public String getTable(){
    	return this.table_name;
    }
    public  void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
   public void query(String query){
	   try
       {
           stmt = conn.createStatement();
           query.replace("TABLE_NAME", table_name);
           stmt.execute(query);
           stmt.close();
       }catch (SQLException sqlExcept)
       {
           sqlExcept.printStackTrace();
       }
   }
    public void insert(String column[], String value[], String type[])
    {
    	if(conn!=null){
	        try
	        {
	        	
	            stmt = conn.createStatement();
	            
	            String query = "insert into " + table_name + " (";
	            for(int i=0;i<column.length;i++){
	            	query += column[i] + ", ";
	            }
	            query = query.substring(0, query.length()-2);
	            
	            query += " ) values (";
	            
	           for(int i=0;i<value.length;i++){
	        	   if(type[i].contentEquals("int"))
	     	            	query += value[i] + ", ";
	        	   else
	        		   query += "'" + value[i] + "', ";
	     	            	
	     	   }		
	           query = query.substring(0, query.length()-2);
	            query += " )";
	            stmt.execute(query);
	            //stmt.closeOnCompletion();
	            //
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	        finally{
	        	try {
					if(stmt!=null)stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
    	}
    }
    public ResultSet selectQuery(String query){
    	
    	try
        {
            stmt = conn.createStatement();
            query.replace("TABLE_NAME", table_name);
            results = stmt.executeQuery(query);
            stmt.close();
        }catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    	return results;
    }
    public ResultSet select(String column[]){
    	try
        {
        	
            stmt = conn.createStatement();
            String query = "select ";
            for(int i=0;i<column.length;i++){
            	query += column[i] + ", ";
            }
            query = query.substring(0, query.length()-3);
            
            query += " from "+ table_name;
            results = stmt.executeQuery(query);
            stmt.close();
        }catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    	return results;
    }
    
    public ResultSet selectAll()
    {
    	ResultSet results=null;
    	if(conn!=null){
	        try
	        {
	            stmt = conn.createStatement();
	            results = stmt.executeQuery("select * from " + table_name);
	            results.close();
	            stmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
    	}
        return results;
    }
    
    public void closeConnection()
    {
        try
        {
            if (conn != null)
            {
            	conn.close();
                //DriverManager.getConnection(dbURL + ";shutdown=true");
                
            }           
        }
        catch (SQLException sqlExcept)
        {
        	sqlExcept.printStackTrace();
        }

    }
}
