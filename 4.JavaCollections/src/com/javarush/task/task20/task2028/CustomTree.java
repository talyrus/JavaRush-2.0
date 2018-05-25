package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
	Entry<String> root;

	static class Entry<T> implements Serializable {
		String elementName;
		int lineNumber;
		boolean availableToAddLeftChildren;
		boolean availableToAddRightChildren;
		Entry<T> parent, leftChild, rightChild;

		public Entry(String elementName) {
			this.elementName = elementName;
			this.availableToAddLeftChildren = true;
			this.availableToAddRightChildren = true;
		}

		void CheckChildren() {
			if (leftChild != null) {
				availableToAddLeftChildren = false;
			} else if (rightChild != null) {
				availableToAddRightChildren = false;
			}
		}

		public boolean isAvailableToAddChildren() {
			return availableToAddLeftChildren || availableToAddRightChildren;
		}
	}

	@Override
	public String get(int index) {
		throw new UnsupportedOperationException();

	}

	@Override
	public int size() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}
