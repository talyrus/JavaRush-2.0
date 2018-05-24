package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;
/**
 * Created by Taly on 24.01.2018.
 */
public enum Dish { // список блюд
	Fish(25),
	Steak(30),
	Soup(15),
	Juice(5),
	Water(3);

	private int duration;

	Dish(int duration) {
		this.duration = duration;
	}

	public static String allDishesToString() { // отображение блюд пользователю
		// StringBuilder stringBuilder = new StringBuilder("");
		// Dish[] dishes = Dish.values();
		// stringBuilder.append(dishes[0]);
		// for (int i = 1; i < dishes.length; i++) {
		//     stringBuilder.append(", ").append(dishes[i]);
		// }
		// return stringBuilder.toString();
		return Arrays.toString(Dish.values()).substring(1, Arrays.toString(Dish.values()).length() - 1);
	}

	public int getDuration() {
		return duration;
	}
}


