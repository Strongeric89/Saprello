package com.saprello.springboot.angular.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface UserRepository extends JpaRepository<User, Long> {
}