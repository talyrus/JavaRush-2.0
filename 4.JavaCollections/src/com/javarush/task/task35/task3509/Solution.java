package com.javarush.task.task35.task3509;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/* 
Collections & Generics
*/
public class Solution {

	public static void main(String[] args) {
/*		ArrayList<Integer> testList = newArrayList(new Integer(5), new Integer(10), new Integer(20));
		for (Integer el : testList) {
			System.out.println(el.toString());
		}*/
	}

	public static <T> ArrayList<T> newArrayList(T... elements) {
		//напишите тут ваш код
		ArrayList<T> list = new ArrayList<>();
		for (Object el : elements) {
			list.add((T) el);
		}
		return list;
	}

	public static <T> HashSet<T> newHashSet(T... elements) {
		//напишите тут ваш код
		HashSet<T> hashSet = new HashSet<>();
		for (Object el : elements) {
			hashSet.add((T) el);
		}
		return hashSet;
	}

	public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
		//напишите тут ваш код
		HashMap<K, V> hashMap = new HashMap<>();
		if (keys.size() == values.size()) {
			for (int i = 0; i < keys.size(); i++) {
				hashMap.put(keys.get(i), values.get(i));
			}
		} else
			throw new IllegalArgumentException();
		return hashMap;
	}
}
