package com.bootcamp.RestFulWebServicePart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/greetings")
    public String greetingsWithUsernameInternationalized(@RequestParam String username){
        return messageSource.getMessage("hello.message",
                null, LocaleContextHolder.getLocale()) + " " + username;
    }

    /*@GetMapping(value = "/goodmorning")
    public String greetingsInternationalized(){
        return messageSource.getMessage("greeting.message",
                null, LocaleContextHolder.getLocale());
    }*/
}
