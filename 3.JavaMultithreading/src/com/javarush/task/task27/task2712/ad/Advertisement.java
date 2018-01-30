package com.javarush.task.task27.task2712.ad;

/**
 * Created by Taly on 30.01.2018.
 */
public class Advertisement {
	Object content; // видео
	String name; // имя/название
	long initialAmount; // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
	int hits; // количество оплаченных показов
	int duration; // продолжительность в секундах

	public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
		this.content = content;
		this.name = name;
		this.initialAmount = initialAmount;
		this.hits = hits;
		this.duration = duration;
	}
}
