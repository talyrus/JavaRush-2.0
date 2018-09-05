package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 * Created by Taly on 05.09.2018.
 */
public class RedShapeDecorator extends ShapeDecorator {
	private Shape shape;

	private void setBorderColor(Shape shape) {
		System.out.println("Setting border color for " + shape.getClass().getSimpleName() + " to red.");
	}

	@Override
	public void draw() {
		setBorderColor(shape);
		super.draw();
	}

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
		this.shape = decoratedShape;
	}
}
