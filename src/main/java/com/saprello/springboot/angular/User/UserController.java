package com.saprello.springboot.angular.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class UserController{
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/users")
    public Collection<User> endPoint() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
    
    @RequestMapping(method = RequestMethod.POST, value ="api/users")
    public void createUser(@RequestBody User user) {
    	if( UserCommandLineRunner.createUser(user) == 0)
    		System.out.print("Error!");
    	else
    		System.out.print("Success!");
    }	
}
