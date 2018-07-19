package com.javarush.task.task36.task3601;

/**
 * Created by Taly on 19.07.2018.
 */
public class View {
	public void fireEventShowData() {
		System.out.println(new Controller().onDataListShow());
	}
}
