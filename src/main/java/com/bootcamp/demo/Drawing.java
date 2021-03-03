package com.bootcamp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Drawing {

    @Autowired
    final Shape shape;

    Drawing(Shape shape){
        super();
        this.shape=shape;
    }
}
