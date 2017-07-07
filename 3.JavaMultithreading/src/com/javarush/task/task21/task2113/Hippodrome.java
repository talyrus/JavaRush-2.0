package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taly on 07.07.2017.
 */
public class Hippodrome { //1. Создадим класс
	private List<Horse> horses; //2. создали поле типа List<Horse>
	static Hippodrome game; //6. Создали статическое поле game типа Hippodrome.

	public List<Horse> getHorses() { // 2. создали метод, возвращающий список
		return horses;
	}

	public Hippodrome(List<Horse> horses) { // 3. создадим конструктор класса Hippodrome с одним параметром типа List.
		this.horses = horses;
	}

	public void run() { //7. Добавим метод run - управляет методами move, print

	}
	public void move() { //7. Добавим метод move - управляет движением всех лошадей

	}
	public void print() { //7. Добавим метод print - управляет отрисовкой лошадей на экране

	}


	public static void main(String[] args) {
		game = new Hippodrome(new ArrayList<>()); // 6. Создадим поле game типа Hippodrome

		Horse h1 = new Horse("H1", 3, 0); // 6. Создадим лошадей
		Horse h2 = new Horse("H2", 3, 0);
		Horse h3 = new Horse("H3", 3, 0);

		game.getHorses().add(h1); // 6. Добавим лошадей в ипподром
		game.getHorses().add(h2);
		game.getHorses().add(h3);

	}
}
