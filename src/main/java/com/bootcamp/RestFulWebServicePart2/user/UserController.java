package com.bootcamp.RestFulWebServicePart2.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public MappingJacksonValue createUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        MappingJacksonValue mapping = new MappingJacksonValue(user1);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","birthDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("passwordFilter",filter);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUser(){
        List<User> userList = userService.findAll();
        MappingJacksonValue mapping = new MappingJacksonValue(userList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","birthDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("passwordFilter",filter);
        mapping.setFilters(filters);
        return mapping;
    }

    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable int id){
        User user = userService.deleteUser(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
    }
}
