package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;

public class VeryComplexClass {
	public void methodThrowsClassCastException() {
		Object object = new Date();
		Integer dateInt = (Integer) object;
	}

	public void methodThrowsNullPointerException() {
		String name = null;
		System.out.println(name.length());
	}

	public static void main(String[] args) {
		VeryComplexClass vcc = new VeryComplexClass();
		//vcc.methodThrowsClassCastException();
		vcc.methodThrowsNullPointerException();
	}
}
