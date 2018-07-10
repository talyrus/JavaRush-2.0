package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Taly on 10.07.2018.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
	private static final Object PRESENT = new Object();
	private transient HashMap<E, Object> map;

	public AmigoSet() {
		map = new HashMap<>();
	}

	public AmigoSet(Collection<? extends E> collection) {
		int capacity = Math.max(16, (int) Math.ceil(collection.size() / .75f));
		this.map = new HashMap<>(capacity);
		for (E e : collection) {
			map.put(e, PRESENT);
		}
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return super.contains(o);
	}

	@Override
	public boolean add(E e) {
		return map.put(e, PRESENT) == null;

	}

	@Override
	public boolean remove(Object o) {
		return super.remove(o);
	}

	@Override
	public void clear() {
		super.clear();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
