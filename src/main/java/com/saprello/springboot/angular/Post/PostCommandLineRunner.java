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


import com.saprello.springboot.angular.AngularApplication;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import java.sql.*;
import java.time.LocalDateTime;
@Component
public class PostCommandLineRunner implements CommandLineRunner {

    private final PostRepository repository;
   
    public static Statement state = null;
    public static ResultSet res = null;
    
    

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


    	
    	String sql = "SELECT * FROM SAPRELLO.POST";
    	
        Connection conn = AngularApplication.dbConnection();
       
        if (conn != null) {
            try {
                System.out.println("Connection to HANA successful!");
                state = conn.createStatement();
                res = state.executeQuery(sql);
                System.out.println("Queried ...");

                /*
                int i = 0;
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(i));
                    repository.save(new Post(resultSet.getString(i)));
                    i++;
                }
                */
                

            } catch (SQLException e) {
                System.err.println("Query failed!");
            }

        /*Stream.of("Post1", "Post2", "Post3", "Post4",
                "Post5", "Post6", "Post7").forEach(name ->
                repository.save(new Post(name))
        );
        */
            repository.findAll().forEach(System.out::println);
        }

    }
    
    
    public PostRepository selectPost(int postId) {
    	
    		
    	Connection conn = AngularApplication.dbConnection();
    	
    	if(conn!=null) {
    		try {
				state = conn.createStatement();
				
				//updating dateAdded first, then the parameters passed in ... returns 0 or 1
				state.executeQuery("SELECT * FROM SAPRELLO.POST WHERE POST_ID='"+postId+"'");
				
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Query failed");
			}
    	}
    	
    	Stream.of("Post1", "Post2", "Post3", "Post4",
                "Post5", "Post6", "Post7").forEach(name ->
                repository.save(new Post(name))
        );
    	
    	return repository;
    	
    }
    
    
    
    public int addPost(Date dateDue, String title, String description, int priority, int likeCount, int groupId, String userId) {

    	//String sql = "INSERT INTO SAPRELLO.POST VALUES (LocalDateTime.now(), value2, value3, ...);";
   
    	Connection conn = AngularApplication.dbConnection();
    	

    	if(conn!=null) {
    		try {
				state = conn.createStatement();
				
				//updating dateAdded first, then the parameters passed in ... returns 0 or 1
				return state.executeUpdate("INSERT INTO SAPRELLO.POST VALUES ("+LocalDateTime.now()+", "+ dateDue+", "+ title+", "+ description+", "+ priority+", "+ likeCount+", "+ groupId+", "+ userId+")");
				
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Query failed");
			}
    	}
    	
    	return 0;
    
    }
    
    public int deletePost(int postId) {

    	//String sql = "INSERT INTO SAPRELLO.POST VALUES (LocalDateTime.now(), value2, value3, ...);";
   
    	Connection conn = AngularApplication.dbConnection();
    	

    	if(conn!=null) {
    		try {
				state = conn.createStatement();
				
				//returns 0 or 1
				return state.executeUpdate("DELETE FROM SAPRELLO.POST WHERE POST_ID='"+postId+"'");
				
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Query failed");
			}
    	}
    	
    	return 0;
    
    }
    
    
    public int editPost(Date dateDue, String title, String description, int priority, int likeCount, int groupId, String userId) {

    	//String sql = "INSERT INTO SAPRELLO.POST VALUES (LocalDateTime.now(), value2, value3, ...);";
   
    	Connection conn = AngularApplication.dbConnection();
    	

    	if(conn!=null) {
    		try {
				state = conn.createStatement();
				
				//updating dateAdded first, then the parameters passed in ... returns 0 or 1
				return state.executeUpdate("INSERT INTO SAPRELLO.POST VALUES ("+LocalDateTime.now()+", "+ dateDue+", "+ title+", "+ description+", "+ priority+", "+ likeCount+", "+ groupId+", "+ userId+")");
				
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Query failed");
			}
    	}
    	
    	return 0;
    
    }
    
    
    
    
    
   
}



