package com.bootcamp.RestFulWebServicePart2.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public List<User> retrieveAllUser(){
        List<User> userList = userService.findAll();
        /*MappingJacksonValue mapping = new MappingJacksonValue(userList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","birthDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("passwordFilter",filter);
        mapping.setFilters(filters);*/
        return userList;
    }

    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable int id){
        User user = userService.deleteUser(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> retrieveOneUser(@PathVariable int id){
        User user = userService.findUser(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUser());
        entityModel.add(linkBuilder.withRel("all-user"));
        return entityModel;
    }
}
