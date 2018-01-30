package com.javarush.task.task27.task2712.ad;

/**
 * Created by Taly on 30.01.2018.
 */
public class AdvertisementStorage { //хранилище рекламных роликов
	private static volatile AdvertisementStorage instance;

	private AdvertisementStorage() {
	}

	public static AdvertisementStorage getInstance() {
		return instance;
	}
}
