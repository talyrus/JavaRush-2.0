package com.javarush.task.task21.task2113;

import java.util.List;

/**
 * Created by Taly on 07.07.2017.
 */
public class Hippodrome {
	private List<Horse> horses; //создали поле типа List<Horse>

	public List<Horse> getHorses() { // создали метод, возвращающий список
		return horses;
	}

	public Hippodrome(List<Horse> horses) { // создадим конструктор класса Hippodrome с одним параметром типа List.
		this.horses = horses;
	}

	public static void main(String[] args) {

	}
}
