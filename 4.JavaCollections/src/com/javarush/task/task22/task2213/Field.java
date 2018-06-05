package com.javarush.task.task22.task2213;

/**
 * Created by Taly on 05.06.2018.
 */
public class Field {
	private int width; // ширина
	private int height; // высота
	private int[][] matrix; // y - высота (номер строки), x - ширина (номер столбца)

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new int[height][width];
	}
}
