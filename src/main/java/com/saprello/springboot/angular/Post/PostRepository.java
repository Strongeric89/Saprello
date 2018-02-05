package com.saprello.springboot.angular.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface PostRepository extends JpaRepository<Post, Long> {
}