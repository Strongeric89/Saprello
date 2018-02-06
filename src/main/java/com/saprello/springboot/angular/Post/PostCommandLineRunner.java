//This methods in involved with pulling data from hana database

package com.saprello.springboot.angular.Post;
import org.springframework.stereotype.Component;

import com.saprello.springboot.angular.AngularApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;

@Component
public class PostCommandLineRunner implements CommandLineRunner {
	private final PostRepository repository;
    
    
    //Creates a repository to store results from database query
    public PostCommandLineRunner(PostRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void run(String... strings) throws Exception {
    	//If the there is a connection continue
    	Connection connection = AngularApplication.dbConnection();
    	if(connection != null) {
    		Statement stmt = connection.createStatement();
    		//Prints all 
    		repository.findAll().forEach(System.out::println);
    		
    	}
            //need to replace gets all repository.findAll().forEach(System.out::println);
    }
    
}

