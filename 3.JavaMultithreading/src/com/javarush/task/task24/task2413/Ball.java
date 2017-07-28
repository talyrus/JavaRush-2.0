package com.javarush.task.task24.task2413;

/**
 * Created by Taly on 26.07.2017.
 */
public class Ball extends BaseObject {
	private double speed, direction, dx, dy;
	private boolean isFrozen = true;

	public double getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	void setDirection(double direction) {
		this.direction = direction;
		double angle = Math.toRadians(direction);
		dx = Math.cos(angle) * speed;
		dy = -Math.cos(angle) * speed;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public Ball(double x, double y, double radius) {
		super(x, y, radius);
	}

	public Ball(double x, double y, double speed, double direction) {
		super(x, y, 1);
		this.speed = speed;
		this.direction = direction;
	}

	@Override
	void draw(Canvas canvas) {
		canvas.setPoint(x, y, 'O');
	}

	@Override
	void move() {
		if (!isFrozen) {
			x += getDx();
			y += getDy();
		}
	}

	void start() {
		isFrozen = false;
	}

	void checkRebound(int minx, int maxx, int miny, int maxy) {

	}
}
