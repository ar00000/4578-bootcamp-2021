package com.bootcamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFramework {

	//loosely coupled example
	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringFramework.class,args);
		Drawing drawing = applicationContext.getBean(Drawing.class);
	//	System.out.println(applicationContext.getEnvironment());
		String result=drawing.shape.draw();
		System.out.println(result);
	}

}
