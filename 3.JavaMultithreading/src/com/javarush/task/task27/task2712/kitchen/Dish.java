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
		StringBuilder stringBuilder = new StringBuilder("");
		Dish[] dishes = Dish.values();
		stringBuilder.append(dishes[0]);
		for (int i = 1; i < dishes.length; i++) {
			stringBuilder.append(", ").append(dishes[i]);
		}
		return stringBuilder.toString();
	}
}


