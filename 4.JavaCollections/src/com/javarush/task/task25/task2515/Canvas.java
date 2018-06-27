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
		matrix = new char[height + 2][width + 2];
	}

	public void setPoint(double x, double y, char c) {
		int xx = (int) Math.round(x);
		int yy = (int) Math.round(y);
		if (x > 0 && y > 0 && y <= matrix.length && x <= matrix[0].length) {
			matrix[yy][xx] = c;
		}
	}

	public void drawMatrix(double x, double y, int[][] matrix, char c) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					setPoint(x + j, y + i, c);
				}
			}
		}
	}

	public void clear() {
		this.matrix = new char[height + 2][width + 2];
	}

	public void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}
