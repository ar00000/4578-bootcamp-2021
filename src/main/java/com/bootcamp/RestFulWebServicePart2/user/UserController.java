package com.bootcamp.RestFulWebServicePart2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
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
        List<User> userList = userService.findAll();
        return userList;
    }

    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable int id){
        User user = userService.deleteUser(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
    }
}
