package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by Taly on 06.02.2018.
 */
public class Model { //будет содержать игровую логику и хранить игровое поле.
	private static final int FIELD_WIDTH = 4; //определяющая ширину игрового поля.
	private Tile[][] gameTiles; //Приватный двумерный массив состоящий из объектов класса Tile.
	protected int score;    //хранит текущий счет
	protected int maxTile;  // хранит максимальный вес плитки на игровом поле
	private Stack<Tile[][]> previousStates = new Stack<>();
	private Stack<Integer> previousScores = new Stack<>();
	private boolean isSaveNeeded = true;

	public Model() { //инициализирующий игровое поле и заполняющий его пустыми плитками.
		resetGameTiles();
		score = 0;
		maxTile = 2;
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
		List<Tile> listTile = new ArrayList<>(); // создадим список
		for (int i = 0; i < FIELD_WIDTH; i++) { // берем строку
			for (int j = 0; j < FIELD_WIDTH; j++) { // берем колонку, перебираем вправо
				if (gameTiles[i][j].isEmpty()) { // если вес плитки равен 0
					listTile.add(gameTiles[i][j]); // добавим ее в список
				}
			}
		}
		return listTile;
	}

	protected void resetGameTiles() { //должен заполнять массив gameTiles новыми плитками и менять значение двух из них с помощью двух вызовов метода addTile.
		gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH]; // создадим двухмерных массив
		for (int i = 0; i < FIELD_WIDTH; i++) { // берем строку
			for (int j = 0; j < FIELD_WIDTH; j++) {     // берем колонку, перебираем вправо
				gameTiles[i][j] = new Tile();   // создаем в текущей позиции массива новую плитку
			}
		}
		addTile();
		addTile();
	}

	private Boolean compressTiles(Tile[] tiles) { //метод сжатия плиток
		boolean isChanged = false;
		for (int i = 0; i < FIELD_WIDTH - 1; i++) { // берем строку
			for (int j = 0; j < FIELD_WIDTH - 1; j++) { // берем колонку, перебираем вправо
				if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) { // если вес проверяемой плитки равен 0, а плитки справа не равен 0
					Tile temp = tiles[j]; // меняем их местами (сортировка пузырем)
					tiles[j] = tiles[j + 1];
					tiles[j + 1] = temp;
					isChanged = true;
				}
			}
		}
		return isChanged;
	}

	private boolean mergeTiles(Tile[] tiles) { // метод слияния плиток одного номинала
		boolean isChanged = false;
		for (int j = 0; j < FIELD_WIDTH - 1; j++) { // берем строку и идем по плиткам вправо
			if (!tiles[j].isEmpty() && tiles[j].value == tiles[j + 1].value) {
				// если вес проверяемой плитки не равен 0 и вес плитки равен весу плитки справа
				tiles[j].value *= 2; // увеличиваем вес текущей плитки
				tiles[j + 1].value = 0; // значению веса плитки справа присваиваем 0
				if (tiles[j].value > maxTile) // если новый вес текущей плитки больше макс. веса плиток на поле
					maxTile = tiles[j].value;   // присвоить новое значение макс. веса
				score += tiles[j].value;    // увеличить значение счета
				isChanged = true;
			}
		}

		if (isChanged) { // если произошло слияние
			Tile temp;
			for (int j = 0; j < FIELD_WIDTH - 1; j++) { //берем строку
				if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
					// если вес текущей плитки равен 0, а вес плитки справа не равен 0
					temp = tiles[j]; // меняем их местами (сортировка пузырем)
					tiles[j] = tiles[j + 1];
					tiles[j + 1] = temp;
				}
			}
		}
		return isChanged;
	}

	protected void left() {
		/**
		 * будет для каждой строки массива gameTiles вызывать методы compressTiles и mergeTiles
		 * и добавлять одну плитку с помощью метода addTile в том случае, если это необходимо
		 */
		if (isSaveNeeded) {
			saveState(gameTiles); //если true, выполняем сохранение состояния перед сдвигом
		}
		boolean isChanged = false;
		for (int j = 0; j < FIELD_WIDTH; j++) { // берем строку
			if (compressTiles(gameTiles[j]) | mergeTiles(gameTiles[j])) {
				isChanged = true;
			}
		}
		if (isChanged == true) {
			addTile();
		}
		isSaveNeeded = true;
	}

	private void rotate() { // метод поворота матрицы на 90 градусов против часовой стрелки
		int size = FIELD_WIDTH;
		for (int i = 0; i < size / 2; i++) { // получим центр матрицы (игрового поля)
			for (int j = i; j < size - 1 - i; j++) { // берем строку
				Tile temp = gameTiles[i][j]; // копируем верхнюю левую плитку во временную переменную
				gameTiles[i][j] = gameTiles[j][size - 1 - i]; // в верхнюю левую копируем верхнюю правую
				gameTiles[j][size - 1 - i] = gameTiles[size - 1 - i][size - 1 - j]; // В верхнюю правую копируем нижнюю правую
				gameTiles[size - 1 - i][size - 1 - j] = gameTiles[size - 1 - j][i]; // в нижнюю правую копируем нижнюю левую
				gameTiles[size - 1 - j][i] = temp; // в нижнюю левую копируем из временной переменной верхнюю левую
			}
		}
	}

	public void up() {
		saveState(gameTiles);
		rotate();
		left();
		rotate();
		rotate();
		rotate();
	}

	public void down() {
		saveState(gameTiles);
		rotate();
		rotate();
		rotate();
		left();
		rotate();
	}

	public void right() {
		saveState(gameTiles);
		rotate();
		rotate();
		left();
		rotate();
		rotate();
	}

	public Tile[][] getGameTiles() { //геттер для поля gameTiles
		return gameTiles;
	}

	public boolean canMove() { //true в случае, если в текущей позиции возможно сделать ход так,
		// чтобы состояние игрового поля изменилось. Иначе - false.
		if (!getEmptyTiles().isEmpty()) // если есть возможность хода (есть пустые плитки)
			return true;
		for (int i = 0; i < gameTiles.length; i++) { // строка
			for (int j = 1; j < gameTiles.length; j++) { // ряд
				if (gameTiles[i][j].value == gameTiles[i][j - 1].value) // плитка равна плитке слева
					return true;
			}
		}
		for (int j = 0; j < gameTiles.length; j++) { // ряд
			for (int i = 1; i < gameTiles.length; i++) { // строка
				if (gameTiles[i][j].value == gameTiles[i - 1][j].value) // плитка равна плитке сверху
					return true;
			}
		}
		return false;
	}

	private void saveState(Tile[][] currentState) {
		Tile[][] newState = new Tile[currentState.length][currentState[0].length];
		for (int i = 0; i < currentState.length; i++) {
			for (int j = 0; j < currentState[0].length; j++) {
				newState[i][j] = new Tile(currentState[i][j].value);
			}
		}
		previousStates.push(newState);
		previousScores.push(score);
		isSaveNeeded = false;
	}

	public void rollback() {
		if (!previousStates.empty() && !previousScores.empty()) {
			gameTiles = previousStates.pop();
			score = previousScores.pop();
		}
	}

	public void randomMove() { //будет вызывать один из методов движения случайным образом
		int n = ((int) (Math.random() * 100)) % 4; //число будет содержать целое псевдослучайное число в диапазоне [0..3]
		switch (n) {
			case 0:
				left();
				break;
			case 1:
				right();
				break;
			case 2:
				up();
				break;
			case 3:
				down();
				break;
		}
	}

	public boolean hasBoardChanged() {
		int gameTilesWt = 0;
		int previousStatesWt = 0;

		Tile[][] psTile = previousStates.peek();
		for (int i = 0; i < gameTiles.length; i++) {
			for (int j = 0; j < gameTiles[0].length; j++) {
				gameTilesWt += gameTiles[i][j].value;
				previousStatesWt += psTile[i][j].value;
			}
		}
		return gameTilesWt != previousStatesWt;
	}

	public MoveEfficiency getMoveEfficiency(Move move) {
		MoveEfficiency moveEfficiency;
		move.move();
		if (hasBoardChanged()) { //если ход изменил состояние игрового поля
			// получим количество пустых клеток, счет
			moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
		} else { //если ход не меняет состояние игрового поля
			moveEfficiency = new MoveEfficiency(-1, 0, move);
		}
		rollback();
		return moveEfficiency;
	}

	public void autoMove() { //будет выбирать лучший из возможных ходов и выполнять его
		//Создадим локальную PriorityQueue с параметром Collections.reverseOrder()
		// (для того, чтобы вверху очереди всегда был максимальный элемент) и размером равным четырем.
		PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
		//Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода).
		priorityQueue.offer(getMoveEfficiency(this::left));
		priorityQueue.offer(getMoveEfficiency(this::right));
		priorityQueue.offer(getMoveEfficiency(this::down));
		priorityQueue.offer(getMoveEfficiency(this::up));
		Move move = priorityQueue.peek().getMove();//Возьмем верхний элемент
		move.move();        //и выполним ход связанный с ним.
	}
}
