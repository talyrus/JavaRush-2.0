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

	public void run() throws InterruptedException { //7. Добавим метод run - управляет методами move, print
		for (int i = 0; i < 100; i++) { //8. Создадим цикл от 1 до 100 и в нем вызовем методы move, print и задержку
			move();
			print();
			Thread.sleep(200);
		}
	}
	public void move() { //7. Добавим метод move - управляет движением всех лошадей
		for (int i = 0; i < horses.size(); i++) {
			horses.get(i).move(); //9. В методе move класса Hippodrome в цикле у каждой лошади вызовем метод move.
		}
	}
	public void print() { //7. Добавим метод print - управляет отрисовкой лошадей на экране
		for (int i = 0; i < horses.size(); i++) {
			horses.get(i).print(); //10. В методе print класса Hippodrome в цикле у каждой лошади вызовем метод print.
		}
		for (int i = 0; i < 10; i++) { //10. Вывести 10 пустых строк
			System.out.println();
		}
	}


	public static void main(String[] args) throws InterruptedException {
		game = new Hippodrome(new ArrayList<>()); // 6. Создадим поле game типа Hippodrome

		Horse h1 = new Horse("H1", 3, 0); // 6. Создадим лошадей
		Horse h2 = new Horse("H2", 3, 0);
		Horse h3 = new Horse("H3", 3, 0);

		game.getHorses().add(h1); // 6. Добавим лошадей в ипподром
		game.getHorses().add(h2);
		game.getHorses().add(h3);

		game.run(); //11. Вызовем метод run
	}
}
