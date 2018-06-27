package com.javarush.task.task25.task2515;

/**
 * Created by Taly on 26.06.2018.
 */
public class Bomb extends BaseObject {
	public Bomb(double x, double y) {
		super(x, y, 1);
	}

	public void move() {
		y++;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.setPoint(x, y, 'B');
	}
}
