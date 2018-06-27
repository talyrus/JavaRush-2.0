package com.javarush.task.task25.task2515;

/**
 * Created by Taly on 26.06.2018.
 */
public class Canvas {
	private int width;
	private int height;
	private char[][] matrix;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new char[height][width];
	}
}
