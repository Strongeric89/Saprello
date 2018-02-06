package com.saprello.springboot.angular.Post;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import java.sql.*;

import java.util.stream.Stream;
@Component
public class PostCommandLineRunner implements CommandLineRunner {
    public static String connectionString = "jdbc:sap://10.47.247.11:31715/?autocommit=false";
    public static String user = "AUTOTEST";
    public static String password = "Manager2";
    public static String sql = "SELECT title from \"SAPRELLO\".\"POST\"";

    private final PostRepository repository;

    public PostCommandLineRunner(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
        } catch (SQLException e) {
            System.err.println("Connection Failed. User/Passwd Error? Message: " + e.getMessage());
            return;
        }
        if (connection != null) {
            try {
                System.out.println("Connection to HANA successful!");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                System.out.println("Queried ...");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                    repository.save(new Post(resultSet.getString(1)));
                }

            } catch (SQLException e) {
                System.err.println("Query failed!");
            }

            repository.findAll().forEach(System.out::println);
        }

    }
}


