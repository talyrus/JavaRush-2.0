package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
	static final long serialVersionUID = 123456789L;
	private HashMap<K, List<V>> map;
	private int repeatCount;

	public MyMultiMap(int repeatCount) {
		this.repeatCount = repeatCount;
		map = new HashMap<>();
	}

	@Override
	public int size() {
		//напишите тут ваш код
		return values().size();
	}

	@Override
	public V put(K key, V value) {
		//напишите тут ваш код
		List<V> vList = map.get(key);
		V oldValue = null;

		if (vList == null) {
			vList = new ArrayList<>();

		} else {
			oldValue = vList.get(vList.size() - 1);
			if (vList.size() == repeatCount)
				vList.remove(0);
		}

		vList.add(value);
		map.put(key, vList);
		return oldValue;

	}

	@Override
	public V remove(Object key) {
		//напишите тут ваш код
		List<V> vList = map.get(key);
		if (vList == null)
			return null;

		V storeValue = vList.get(0);
		vList.remove(0);

		if (vList.size() == 0)
			map.remove(key);

		return storeValue;
	}

	@Override
	public Set<K> keySet() {
		//напишите тут ваш код
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		//напишите тут ваш код

		ArrayList<V> vArrayList = new ArrayList<>();
		for (List<V> value : map.values()) {
			vArrayList.addAll(value);
		}
		return vArrayList;
	}

	@Override
	public boolean containsKey(Object key) {
		//напишите тут ваш код
		return keySet().contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		//напишите тут ваш код
		return values().contains(value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (Map.Entry<K, List<V>> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append("=");
			for (V v : entry.getValue()) {
				sb.append(v);
				sb.append(", ");
			}
		}
		String substring = sb.substring(0, sb.length() - 2);
		return substring + "}";
	}
}
