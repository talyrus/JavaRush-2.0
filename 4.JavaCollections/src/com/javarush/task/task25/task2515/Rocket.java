package com.javarush.task.task25.task2515;

/**
 * Created by Taly on 26.06.2018.
 */
public class Rocket extends BaseObject {
	public Rocket(double x, double y) {
		super(x, y, 1);
	}

	/**
	 * Отрисовываем себя на холсте.
	 */
	@Override
	public void draw(Canvas canvas) {
		canvas.setPoint(x, y, 'R');
	}

	/**
	 * Двигаем себя вниз на один ход.
	 */
	@Override
	public void move() {
		y--;
	}
}
