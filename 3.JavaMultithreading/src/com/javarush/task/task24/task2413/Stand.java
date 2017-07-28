package com.javarush.task.task24.task2413;

/**
 * Created by Taly on 26.07.2017.
 */
public class Stand extends BaseObject {
	private double speed, direction;
	//direction -(направление движения по оси x:
	// 1 — вправо, -1 — влево, 0 — начальное значение, стоим на месте)


	public double getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	public Stand(double x, double y) {
		super(x, y, 3);
		speed = 1;
		direction = 0;
	}

	public Stand(double x, double y, double radius) {
		super(x, y, radius);
	}

	@Override
	void draw(Canvas canvas) {

	}

	@Override
	void move() {
		x += direction * speed;
	}

	void moveLeft() {
		direction = -1;
	}

	void moveRight() {
		direction = 1;
	}
}
