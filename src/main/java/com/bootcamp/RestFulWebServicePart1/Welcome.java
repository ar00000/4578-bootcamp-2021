package com.bootcamp.RestFulWebServicePart1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public String showWelcome(){
        return "Welcome to spring boot";
    }
}
