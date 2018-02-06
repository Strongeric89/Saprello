//This methods in involved with pulling data from hana database

package com.saprello.springboot.angular.User;
import org.springframework.stereotype.Component;

import com.saprello.springboot.angular.AngularApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	private final UserRepository repository;
    
    
    //Creates a repository to store results from database query
    public UserCommandLineRunner(UserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void run(String... strings) throws Exception {
    	//If the there is a connection continue
    	Connection connection = AngularApplication.dbConnection();
    	if(connection != null) {
    		ResultSet allUsers = getAllUser(connection);
    		while (allUsers.next()) {
                //ID: System.out.println(allUsers.getString(1));
                //Name: System.out.println(allUsers.getString(2));
                //Email:System.out.println(allUsers.getString(3));
                //Password: System.out.println(allUsers.getString(4));
                repository.save(new User(allUsers.getString(2), allUsers.getString(3), allUsers.getString(4), 
                		allUsers.getLong(5)));
            }
    		
    		
    	}
    		repository.findAll().forEach(System.out::println);
    } 
    
    public ResultSet getAllUser(Connection conn) {
    	String sql = "SELECT * from \"SAPRELLO\".\"USER\"";
    	ResultSet allUsers = null;
    	if(conn != null) {
    		try {
    			//Exceutes sql query and equals result to resultset and returns
	    		Statement stmt = conn.createStatement();
	    		allUsers = stmt.executeQuery(sql);
	    		return allUsers;
    		} catch (SQLException e) {
    			//Query error
                System.err.println("Query failed!");
            }
    	}
		return allUsers;
    }
}