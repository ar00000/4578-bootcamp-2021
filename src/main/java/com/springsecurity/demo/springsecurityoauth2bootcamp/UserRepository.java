package com.springsecurity.demo.springsecurityoauth2bootcamp;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
