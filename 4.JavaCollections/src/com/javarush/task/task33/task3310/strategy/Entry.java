package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Taly on 02.08.2018.
 */
public class Entry implements Serializable {
	Long key;
	String value;
	Entry next;
	int hash;

	public Entry(int hash, Long key, String value, Entry next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public Long getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public int hashCode() {
		return key.hashCode() ^ value.hashCode();
	}

	public String toString() {
		return key + "=" + value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Entry entry = (Entry) o;
		return Objects.equals(key, entry.key) &&
				Objects.equals(value, entry.value);
	}
}
