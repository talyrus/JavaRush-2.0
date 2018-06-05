package com.javarush.task.task22.task2213;

/**
 * Created by Taly on 05.06.2018.
 */
public class Field {
	private int width; // ширина
	private int height; // высота
	private int[][] matrix; // y - высота (номер строки), x - ширина (номер столбца)

	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new int[height][width];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void print() { //объект будет отрисовывать на экран свое текущее состояние
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 0) {
					System.out.print(".");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}

	public void removeFullLines() { // будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз

	}

	public Integer getValue(int x, int y) { //возвращает значение которое находится в матрице с координатами x и y
		return null;
	}

	public void setValue(int x, int y, int value) { //устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y
		
	}


}
