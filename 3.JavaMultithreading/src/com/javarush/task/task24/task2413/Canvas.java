package com.javarush.task.task24.task2413;

/**
 * Created by Taly on 26.07.2017.
 */
public class Canvas {
	private int width, height;
	private char[][] matrix;

	public Canvas(int width, int height) { // ширина, высота
		this.width = width;     //ширина
		this.height = height; //высота
		matrix = new char[height + 2][width + 2]; //высота, ширина
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

	void setPoint(double x, double y, char c) {
		if (x < 0 || y < 0 || y > matrix.length || x > matrix[0].length) {
			// y = matrix.length верхний угол         // x > matrix[0].length правый угол
		} else {
			matrix[(int) Math.round(y)][(int) Math.round(x)] = c;
			// y - количество строк - высота, x - количество членов в строке массива - ширина
		}
	}

	void drawMatrix(double x, double y, int[][] matrix, char c) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != 0) {
					this.setPoint(x + j, y + i, c);
				}
			}
		}
	}
}
