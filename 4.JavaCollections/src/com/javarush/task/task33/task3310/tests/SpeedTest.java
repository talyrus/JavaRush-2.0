package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Taly on 08.08.2018.
 */
public class SpeedTest {
	//должен возвращать время в миллисекундах
	// необходимое для получения идентификаторов для всех строк из strings.
	// Идентификаторы должны быть записаны в ids
	public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
		Date start = new Date();
		for (String str : strings) {
			ids.add(shortener.getId(str));
		}
		Date finish = new Date();
		return finish.getTime() - start.getTime();
	}

	//должен возвращать время в миллисекундах необходимое для получения
	// строк для всех строк из ids. Строки должны быть записаны в strings
	public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
		Date start = new Date();
		for (Long id : ids) {
			strings.add(shortener.getString(id));
		}
		Date finish = new Date();
		return finish.getTime() - start.getTime();
	}

	@Test
	public void testHashMapStorage() {
		//Создавать два объекта типа Shortener, один на базе HashMapStorageStrategy,
		// второй на базе HashBiMapStorageStrategy
		Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
		Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
		//Генерировать с помощью Helper 10000 строк и помещать их в сет со строками
		Set<String> origStrings = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			origStrings.add(Helper.generateRandomString());
		}
		//Получать время получения идентификаторов для origStrings
		Set<Long> ids1 = new HashSet<>();
		Set<Long> ids2 = new HashSet<>();

		long timeId1 = getTimeForGettingIds(shortener1, origStrings, ids1);
		long timeId2 = getTimeForGettingIds(shortener2, origStrings, ids2);
		//Проверять с помощью junit, что время, для shortener1 больше, чем для shortener2
		Assert.assertTrue(timeId1 > timeId2);

		// Получать время получения строк
		Set<Long> str1 = new HashSet<>();
		Set<Long> str2 = new HashSet<>();

		long timeStr1 = getTimeForGettingStrings(shortener1, ids1, origStrings);
		long timeStr2 = getTimeForGettingStrings(shortener2, ids2, origStrings);

		//Проверять с помощью junit, что время, полученное для shortener1 примерно равно времени для shortener2
		Assert.assertEquals(timeStr1, timeStr2, 30);
	}
}
