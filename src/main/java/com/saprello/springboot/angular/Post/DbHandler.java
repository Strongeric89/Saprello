package com.saprello.springboot.angular.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbHandler {
	
	public static String connectionString = "jdbc:sap://10.47.247.11:31715/?autocommit=false";
	public static Connection conn = null;
	public static ResultSet res = null;
	public static Statement state = null;

    public static String user = "AUTOTEST";
    public static String password = "Manager2";
    public static String sql = "SELECT title from \"SAPRELLO\".\"POST\"";
	
	

}
