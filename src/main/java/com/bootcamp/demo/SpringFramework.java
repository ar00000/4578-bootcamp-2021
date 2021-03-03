package com.bootcamp.demo;
class Drawing {
	private final Shape shape;

	Drawing(Shape shape){
		this.shape=shape;
	}
	//loosely coupled example
	public static void main(String[] args) {
		Drawing drawing = new Drawing(new Rectangle());
		System.out.println(drawing.shape.draw());
		drawing = new Drawing(new Circle());
		System.out.println(drawing.shape.draw());
	}

}
