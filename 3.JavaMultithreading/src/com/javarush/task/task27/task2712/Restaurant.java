package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by Taly on 24.01.2018.
 */
public class Restaurant {
	public static void main(String[] args) {
		Tablet tablet = new Tablet(5);
		tablet.createOrder();
		//В методе main класса Restaurant должен быть создан новый повар
		// и добавлен планшету в качестве наблюдателя с помощью метода addObserver.
		Cook cook = new Cook("Amigo");
		tablet.addObserver(cook);
		Waiter waiter = new Waiter();
		cook.addObserver(waiter);

	}
}
