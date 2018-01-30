package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * Created by Taly on 30.01.2018.
 */
public class AdvertisementManager {
	//у каждого планшета будет свой объект менеджера,
	// который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
	private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
	private int timeSeconds;

	public AdvertisementManager(int timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	public final void processVideos() {
		ConsoleHelper.writeMessage("calling processVideos method");
	}
}
