package com.saprello.springboot.angular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
=======
import java.sql.*;
>>>>>>> branches/josh1

@SpringBootApplication
public class AngularApplication {
    public static String connectionString = "jdbc:sap://10.47.247.11:31715/?autocommit=false";
    public static String user = "AUTOTEST";
    public static String password = "Manager2";

	public static void main(String[] args) {
		SpringApplication.run(AngularApplication.class, args);
		
	}
	
	public static Connection dbConnection() {
        Connection connection = null;
	   try {
	       connection = DriverManager.getConnection("jdbc:sap://10.47.247.11:31715/?autocommit=false", "AUTOTEST", "Manager2");
	   } catch (SQLException e) {
	       System.err.println("Connection Failed. User/Passwd Error? Message: " + e.getMessage());
	   }
	   if (connection != null) {
	           System.out.println("Connection to HANA successful!");
	               return connection; 
	   }
   
   		return connection;
	}
	
<<<<<<< HEAD
	//Method to create a connection with the hana database
	public static Connection dbConnection() {
		Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
        } catch (SQLException e) {
            System.err.println("Connection Failed. User/Passwd Error? Message: " + e.getMessage());
        }
        if (connection != null) {
                System.out.println("Connection to HANA successful!");
        		return connection; 
        }
        return connection;
	}
=======
	
>>>>>>> branches/josh1
}

