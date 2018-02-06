package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taly on 06.02.2018.
 */
public class Model { //будет содержать игровую логику и хранить игровое поле.
	private static final int FIELD_WIDTH = 4; //определяющая ширину игрового поля.
	private Tile[][] gameTiles; //Приватный двумерный массив состоящий из объектов класса Tile.

	public Model() { //инициализирующий игровое поле и заполняющий его пустыми плитками.
		resetGameTiles();
	}

	private void addTile() { //должен изменять значение случайной пустой плитки в массиве gameTiles на 2 или 4 с вероятностью 0.9 и 0.1 соответственно.
		List<Tile> listEmptyTiles = getEmptyTiles(); // получим список пустых плиток
		if (listEmptyTiles != null && listEmptyTiles.size() != 0) {
			int randomEmptyTile = (int) (listEmptyTiles.size() * Math.random()); // получим случайный объект из списка
			int valueNew = Math.random() < 0.9 ? 2 : 4; // вычислим вес новой плитки
			listEmptyTiles.get(randomEmptyTile).value = valueNew; // установим новый вес плитки
		}
	}

	private List<Tile> getEmptyTiles() { // должен возвращать список пустых плиток в массиве gameTiles.
		List<Tile> listTile = new ArrayList<>();
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				if (gameTiles[i][j].isEmpty()) {
					listTile.add(gameTiles[i][j]);
				}
			}
		}
		return listTile;
	}

	protected void resetGameTiles() { //должен заполнять массив gameTiles новыми плитками и менять значение двух из них с помощью двух вызовов метода addTile.
		gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
		for (int i = 0; i < FIELD_WIDTH; i++) {
			for (int j = 0; j < FIELD_WIDTH; j++) {
				gameTiles[i][j] = new Tile();
			}
		}
		addTile();
		addTile();
	}
}
