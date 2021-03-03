package com.bootcamp.demo;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape {
    public String draw(){
        //logic
        return "Drawing Rectangle";
    }
}
