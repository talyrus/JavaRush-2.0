package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Taly on 24.01.2018.
 */
public class Order { // в классе Order (заказ) должна быть информация, относящаяся к списку выбранных пользователем блюд.
	private final Tablet tablet; // ссылка на планшет
	protected List<Dish> dishes; // список выбранных блюд

	public Order(Tablet tablet) throws IOException {
		this.tablet = tablet;
		dishes = ConsoleHelper.getAllDishesForOrder();
	}

	@Override
	public String toString() {
		if (dishes.isEmpty()) {
			return "";
		} else {
			return "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() + "min";
		}
	}

	public int getTotalCookingTime() { //вернем количество времени требующееся на приготовление текущего заказа.
		int timeCooking = 0;
		for (Dish el : dishes) {
			timeCooking += el.getDuration();
		}
		return timeCooking;
	}

	public boolean isEmpty() {
		return dishes.isEmpty();
	}

}
