package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Taly on 06.02.2018.
 */
public class Controller extends KeyAdapter { //будет следить за нажатием клавиш во время игры.
	private Model model;
	private View view;
	private static int WINNING_TILE = 2048; //вес плитки, при достижении которого игра будет считаться выигранной

	public Tile[][] getGameTiles() {
		return model.getGameTiles();
	}

	public int getScore() {
		return model.score;
	}

	public Controller(Model model) {
		this.model = model; //инициализировать поле model
		view = new View(this); //сохранить в поле view новый объект типа View с текущим контроллером(this) в качестве параметра конструктора
	}

	public void resetGame() { //вернуть игровое поле в начальное состояние
		model.score = 0;
		view.isGameWon = false;
		view.isGameLost = false;
		model.resetGameTiles();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			resetGame();
		} else if (!model.canMove()) {
			view.isGameLost = true;
		} else if (!view.isGameLost && !view.isGameWon) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				model.left();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				model.right();
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				model.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				model.down();
			}
		}
		if (model.maxTile == WINNING_TILE) {
			view.isGameWon = true;
		}
		view.repaint();
	}

	public View getView() {
		return view;
	}
}
