package com.javarush.task.task27.task2712.ad;

/**
 * Created by Taly on 30.01.2018.
 */
public class AdvertisementManager {
	//у каждого планшета будет свой объект менеджера,
	// который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
	private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
}
