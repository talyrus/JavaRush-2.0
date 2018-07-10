package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Taly on 10.07.2018.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {


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
		return super.add(e);
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
