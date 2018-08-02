package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Taly on 02.08.2018.
 */
public class Solution {
	public static void main(String[] args) {
		StorageStrategy strategy = new HashMapStorageStrategy(); //Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов
		testStrategy(strategy, 10000);
	}

	public static Set<Long> getIds(Shortener shortener, Set<String> strings) { //должен для переданного множества строк возвращать множество идентификаторов
		Set<Long> hashSetIds = new HashSet<>();
		for (String id : strings) {
			hashSetIds.add(shortener.getId(id));
		}
		return hashSetIds;
	}

	public static Set<String> getStrings(Shortener shortener, Set<Long> keys) { //будет возвращать множество строк, которое соответствует переданному множеству идентификаторов
		Set<String> hashSetStrings = new HashSet<>();
		for (Long str : keys) {
			hashSetStrings.add(shortener.getString(str));
		}
		return hashSetStrings;
	}

	public static void testStrategy(StorageStrategy strategy, long elementsNumber) { //будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber
		Helper.printMessage(strategy.getClass().getSimpleName()); //Выводить имя класса стратегии. Имя не должно включать имя пакета

		Set<String> stringSet = new HashSet<>(); //Генерировать тестовое множество строк
		//Long[] longElements = new Long[(int) elementsNumber];
		for (int i = 0; i < elementsNumber; i++) {
			stringSet.add(Helper.generateRandomString());
		}

		Shortener shortener = new Shortener(strategy); //Создавать объект типа Shortener, используя переданную стратегию

		Date start = new Date(); // Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
		Set<Long> longSetIds = getIds(shortener, stringSet);
		Date finish = new Date();
		long workTime = finish.getTime() - start.getTime();
		Helper.printMessage(Long.toString(workTime));

		start = new Date(); // Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
		Set<String> strings = getStrings(shortener, longSetIds);
		finish = new Date();
		workTime = finish.getTime() - start.getTime();
		Helper.printMessage(Long.toString(workTime));

		if (stringSet.equals(strings)) { //Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings
			Helper.printMessage("Тест пройден.");
		} else {
			Helper.printMessage("Тест не пройден.");
		}

	}
}
