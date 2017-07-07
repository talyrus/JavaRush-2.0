package com.javarush.task.task21.task2113;

import java.util.List;

/**
 * Created by Taly on 07.07.2017.
 */
public class Hippodrome { //1. Создадим класс
	private List<Horse> horses; //2. создали поле типа List<Horse>

	public List<Horse> getHorses() { // 2. создали метод, возвращающий список
		return horses;
	}

	public Hippodrome(List<Horse> horses) { // 3. создадим конструктор класса Hippodrome с одним параметром типа List.
		this.horses = horses;
	}

	public static void main(String[] args) {

	}
}
