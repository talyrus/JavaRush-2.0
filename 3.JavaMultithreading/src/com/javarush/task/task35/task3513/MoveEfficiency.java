package com.javarush.task.task35.task3513;

/**
 * Created by Taly on 08.02.2018.
 */
public class MoveEfficiency {
	private int numberOfEmptyTiles;
	private int score;
	private Move move;

	public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
		this.numberOfEmptyTiles = numberOfEmptyTiles;
		this.score = score;
		this.move = move;
	}

	public Move getMove() {
		return move;
	}
}
