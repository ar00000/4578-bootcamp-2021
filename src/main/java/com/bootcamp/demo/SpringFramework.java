package com.bootcamp.demo;
public class SpringFramework {
	private final Shape shape;

	SpringFramework(Shape shape){
		this.shape=shape;
	}
	//loosely coupled example
	public static void main(String[] args) {
		SpringFramework springFramework = new SpringFramework(new Rectangle());
		System.out.println(springFramework.shape.draw());
		springFramework = new SpringFramework(new Circle());
		System.out.println(springFramework.shape.draw());
	}

}
