package com.bootcamp.RestFulWebServicePart2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> retrieveAllUser(){
        return userService.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable int id){
        User user = userService.deleteUser(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
    }
}
