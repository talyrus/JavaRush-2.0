package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taly on 24.01.2018.
 */
public class ConsoleHelper {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void writeMessage(String message) { //для вывода message в консоль
		System.out.println(message);
	}

	public static String readString() throws IOException { //для чтения строки с консоли. Бросим исключение вверх
		return reader.readLine();
	}

	public static List<Dish> getAllDishesForOrder() throws IOException { //просит пользователя выбрать блюдо и добавляет его в список
		List<Dish> dishes = new ArrayList<>(); // создадим список для выбранных пользователем блюд
		ConsoleHelper.writeMessage(Dish.allDishesToString()); //выведем список блюд
		ConsoleHelper.writeMessage("Выберите необходимое блюдо... Если закончили - введите 'exit'");

		String selectDish;
		while (!(selectDish = readString()).equals("exit")) { // пока пользователь не набрал exit считывае блюда
			try {
				dishes.add(Dish.valueOf(selectDish)); //находим в ENUM введенное блюдо и добавляем его в список выбора
			} catch (IllegalArgumentException e) {
				ConsoleHelper.writeMessage("Блюдо отсутствует!"); // если блюда нет в ENUM, сообщим пользователю
			}
		}
		return dishes;
	}
}
