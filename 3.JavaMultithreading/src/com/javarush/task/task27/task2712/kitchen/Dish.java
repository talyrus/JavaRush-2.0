package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by Taly on 24.01.2018.
 */
public enum Dish { // список блюд
	Fish,
	Steak,
	Soup,
	Juice,
	Water;

	public static String allDishesToString() { // отображение блюд пользователю
		Dish[] allDish = Dish.values(); // получим массив, содержащий список констант перечисления
		StringBuilder stringBuilder = new StringBuilder();
		for (Dish dish : allDish) { // сформируем динамический список перечислений
			stringBuilder.append(dish + ", ");
		}
		// возвратим список, отрезав последние два символа
		return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).toString();
	}
}


