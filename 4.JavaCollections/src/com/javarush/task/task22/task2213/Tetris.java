package com.javarush.task.task22.task2213;

/**
 * Created by Taly on 05.06.2018.
 */
public class Tetris {
	private Field field;
	private Figure figure;
	public static Tetris game;

	public static void main(String[] args) {
		game = new Tetris();
		game.run();
	}

	public Field getField() {
		return field;
	}

	public Figure getFigure() {
		return figure;
	}

	public void run() {

	}

	public void step() {

	}
}
