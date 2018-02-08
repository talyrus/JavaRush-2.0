package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

/**
 * Created by Taly on 06.02.2018.
 */
public class Controller extends KeyAdapter { //будет следить за нажатием клавиш во время игры.
	private Model model;
	private View view;

	public Tile[][] getGameTiles() {
		return model.getGameTiles();
	}

	public int getScore() {
		return model.score;
	}
}
