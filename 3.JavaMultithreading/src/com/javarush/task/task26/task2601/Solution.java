package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

	public static void main(String[] args) {
//		Integer[] arr = {13, 8, 15, 5, 17}; // нечетный
//		System.out.println(Arrays.toString(sort(arr)));
//
//		Integer[] mass = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // четный
//		System.out.println(Arrays.toString(sort(mass)));
	}

	public static Integer[] sort(Integer[] array) {
		//implement logic here
		final double mediana;
		//найдем значение медианы

		Arrays.sort(array);
		if (array.length % 2 == 0) {
			//System.out.println("в массиве четное количество элементов");
			mediana = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
			//System.out.println("mediana " + mediana);
		} else {
			//System.out.println("в массиве НЕ четное количество элементов");
			mediana = array[array.length / 2];
			//System.out.println("mediana " + mediana);
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				double result = Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
				if (result == 0) {
					result = o1 - o2;
				}
				return (int) result;
			}
		};
		Arrays.sort(array, comparator);
		//System.out.println(mediana);
		return array;
	}
}
