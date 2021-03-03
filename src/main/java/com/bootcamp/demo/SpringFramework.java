package com.bootcamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFramework {

	//loosely coupled example
	public static void main(String[] args) {
		//Drawing drawing = new Drawing(new Rectangle());

		ApplicationContext applicationContext=
				SpringApplication.run(SpringFramework.class,args);

		Drawing drawing = applicationContext.getBean(Drawing.class);
		String result=drawing.shape.draw();
		System.out.println(result);
	}

}
