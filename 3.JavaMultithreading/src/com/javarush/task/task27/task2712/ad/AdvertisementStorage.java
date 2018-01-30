package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taly on 30.01.2018.
 */
public class AdvertisementStorage { //хранилище рекламных роликов
	private static AdvertisementStorage instance = new AdvertisementStorage();
	private final List<Advertisement> videos = new ArrayList();

	private AdvertisementStorage() {
		Object someContent = new Object();
		videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));//3 min
		videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));//15 min
		videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));//10 min
	}

	public static AdvertisementStorage getInstance() {
		return instance;
	}

	public List<Advertisement> list() {
		return videos; //вернет список всех существующих доступных видео
	}

	public void add(Advertisement advertisement) {
		videos.add(advertisement); //добавит новое видео в список videos
	}
}
