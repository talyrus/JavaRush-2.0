package com.javarush.task.task37.task3712;

/**
 * Created by Taly on 06.09.2018.
 */
public abstract class Game {

	abstract void prepareForTheGame();

	abstract void playGame();

	abstract void congratulateWinner();

	void run() {
		prepareForTheGame();
		playGame();
		congratulateWinner();
	}
}
