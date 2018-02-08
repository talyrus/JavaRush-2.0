package com.javarush.task.task35.task3513;

/**
 * Created by Taly on 08.02.2018.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency> {
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

	@Override
	public int compareTo(MoveEfficiency o) {
		final int FLAG_BEFORE = -1;
		final int FLAG_EQUAL = 0;
		final int FLAG_AFTER = 1;

		if (this == o)
			return FLAG_EQUAL;

		if (this.numberOfEmptyTiles > o.numberOfEmptyTiles)
			return FLAG_AFTER;
		if (this.numberOfEmptyTiles < o.numberOfEmptyTiles)
			return FLAG_BEFORE;

		if (this.numberOfEmptyTiles == o.numberOfEmptyTiles) {
			if (this.score > o.score)
				return FLAG_AFTER;
			if (this.score < o.score)
				return FLAG_BEFORE;
		}
		return FLAG_EQUAL;
	}
}
