package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Taly on 08.08.2018.
 */
public class FunctionalTest {

	public void testStorage(Shortener shortener) {
		//Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
		String string1 = Helper.generateRandomString();
		String string2 = Helper.generateRandomString();
		String string3 = string1;

		//Получать и сохранять идентификаторы для всех трех строк с помощью shortener
		Long id1 = shortener.getId(string1);
		Long id2 = shortener.getId(string2);
		Long id3 = shortener.getId(string3);

		//Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк
		Assert.assertNotEquals(id2, id1);
		Assert.assertNotEquals(id2, id3);

		//Проверять, что идентификаторы для 1 и 3 строк равны
		Assert.assertEquals(id1, id3);

		//Получать три строки по трем идентификаторам с помощью shortener
		String strId1 = shortener.getString(id1);
		String strId2 = shortener.getString(id2);
		String strId3 = shortener.getString(id3);

		//Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным
		Assert.assertEquals(string1, strId1);
		Assert.assertEquals(string2, strId2);
		Assert.assertEquals(string3, strId3);
	}

	//Добавь в класс FunctionalTest тесты
	//Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию,
	// создавать объект класса Shortener на базе этой стратегии
	// и вызывать метод testStorage для него
	@Test
	public void testHashMapStorageStrategy() {
		HashMapStorageStrategy strategy = new HashMapStorageStrategy();
		Shortener shortener = new Shortener(strategy);
		testStorage(shortener);
	}

	@Test
	public void testOurHashMapStorageStrategy() {
		OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
		Shortener shortener = new Shortener(strategy);
		testStorage(shortener);
	}

	@Test
	public void testFileStorageStrategy() {
		FileStorageStrategy strategy = new FileStorageStrategy();
		Shortener shortener = new Shortener(strategy);
		testStorage(shortener);
	}

	@Test
	public void testHashBiMapStorageStrategy() {
		HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
		Shortener shortener = new Shortener(strategy);
		testStorage(shortener);
	}

	@Test
	public void testDualHashBidiMapStorageStrategy() {
		DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
		Shortener shortener = new Shortener(strategy);
		testStorage(shortener);
	}

	@Test
	public void testOurHashBiMapStorageStrategy() {
		OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
		Shortener shortener = new Shortener(strategy);
		testStorage(shortener);
	}

}
