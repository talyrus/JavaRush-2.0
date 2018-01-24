package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.util.List;

/**
 * Created by Taly on 24.01.2018.
 */
public class Order { // в классе Order (заказ) должна быть информация, относящаяся к списку выбранных пользователем блюд.
	private final Tablet tablet;
	protected List<Dish> dishes; // список выбранных блюд

	public Order(Tablet tablet) {
		this.tablet = tablet;
	}
}
