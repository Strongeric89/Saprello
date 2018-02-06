package com.saprello.springboot.angular.User;

import org.springframework.web.bind.annotation.GetMapping;
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

}
