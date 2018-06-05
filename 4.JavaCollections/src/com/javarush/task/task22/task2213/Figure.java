package com.javarush.task.task22.task2213;

/**
 * Created by Taly on 05.06.2018.
 */
public class Figure {
	private int x;
	private int y;
	private int[][] matrix;

	public Figure(int x, int y, int[][] matrix) {
		this.x = x;
		this.y = y;
		this.matrix = matrix;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void left() { //для движения фигурки влево
		if (isCurrentPositionAvailable()) {
			x--;
		}
	}

	public void right() { //для движения фигурки вправо
		if (isCurrentPositionAvailable()) {
			x++;
		}
	}

	public void down() { //для движения фигурки вниз.
		if (isCurrentPositionAvailable()) {
			y++;
		}
	}

	public void up() { //для движения фигурки вверх.
		if (isCurrentPositionAvailable()) {
			y--;
		}
	}

	public void rotate() { //для поворота фигурки вокруг главной диагонали.

	}

	public void downMaximum() { //падение фигурки в низ до дна.

	}

	public boolean isCurrentPositionAvailable() { //проверка - может ли фигурка быть помещена в текущую позицию
		return true;
	}

	public void landed() { //вызывается, когда фигурка достигла дна или уперлась в другую фигурку

	}
}
