package com.javarush.task.task24.task2413;

import static java.lang.Double.max;

/**
 * Created by Taly on 26.07.2017.
 */
abstract public class BaseObject {
	private double x, y, radius;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public BaseObject(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	abstract void draw(Canvas canvas);

	abstract void move();

	boolean isIntersec(BaseObject o) {
		double dist = Math.sqrt(Math.pow((o.getX() - this.getX()), 2) + Math.pow((o.getY() - this.getY()), 2));
		return dist <= max(this.getRadius(), o.getRadius());
	}
}
