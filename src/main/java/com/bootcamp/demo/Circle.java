package com.bootcamp.demo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Circle implements Shape{
    public String draw(){
        //logic
        return "Drawing Circle";
    }
}
