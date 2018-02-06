package com.javarush.task.task35.task3513;

/**
 * Created by Taly on 06.02.2018.
 */
public class Model { //будет содержать игровую логику и хранить игровое поле.
	private static final int FIELD_WIDTH = 4; //определяющая ширину игрового поля.
	private Tile[][] gameTiles; //Приватный двумерный массив состоящий из объектов класса Tile.

	public Model() { //инициализирующий игровое поле и заполняющий его пустыми плитками.
		gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				gameTiles[i][j] = new Tile();
			}
		}
	}
}
