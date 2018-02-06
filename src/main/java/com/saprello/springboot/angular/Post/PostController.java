package com.saprello.springboot.angular.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class PostController {
    private PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/endpoint")
    public Collection<Post> endPoint() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

}
