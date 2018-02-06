package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	public void processVideos() throws NoVideoAvailableException {
		List<Advertisement> videoList = new ArrayList<>(storage.list()); //список всего видео
		if (videoList.size() == 0) { //Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException
			throw new NoVideoAvailableException();
		}

		Collections.sort(videoList, new Comparator<Advertisement>() {
			@Override
			public int compare(Advertisement o1, Advertisement o2) {
				int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
				if (result != 0) {
					return -result;
				}
				long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
				long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

				return Long.compare(oneSecondCost1, oneSecondCost2);
			}
		});
		long sumAmount = 0;
		int sumDuration = 0;

		List<Advertisement> list = new ArrayList<>();

		int timeLeft = timeSeconds;
		for (Advertisement el : videoList) {
			if (timeLeft < el.getDuration() || el.getHits() <= 0) {
				continue;
			}
			list.add(el);
			sumAmount += el.getAmountPerOneDisplaying();
			sumDuration += el.getDuration();
			timeLeft -= el.getDuration();
		}
		if (timeLeft == timeSeconds) {
			throw new NoVideoAvailableException();
		}

		for (Advertisement el : list) {
			ConsoleHelper.writeMessage(el.getName() + " is displaying... "
					+ el.getAmountPerOneDisplaying() + ", "
					+ el.getAmountPerOneDisplaying() * 1000 / el.getDuration());
			el.revalidate();
		}

	}
}
