package com.bootcamp.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Drawing {
    @Autowired
    Shape shape;

    Drawing(Shape shape){
        this.shape=shape;
    }
}
