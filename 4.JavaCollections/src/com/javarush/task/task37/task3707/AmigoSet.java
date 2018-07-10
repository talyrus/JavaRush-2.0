package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E>
		extends AbstractSet<E>
		implements Serializable, Cloneable, Set<E> {

	private static final Object PRESENT = new Object();
	private transient HashMap<E, Object> map;

	public AmigoSet() {
		map = new HashMap<>();
	}

	public AmigoSet(Collection<? extends E> collection) {
		int capacity = Math.max(16, (int) (collection.size() / 0.75f + 1));
		map = new HashMap<>(capacity);
		addAll(collection);
	}

	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	@Override
	public boolean remove(Object o) {
		return map.remove(o) == PRESENT;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}

	@Override
	public Object clone() {
		try {
			AmigoSet copy = (AmigoSet) super.clone();
			copy.map = (HashMap) map.clone();
			return copy;
		} catch (Exception e) {
			throw new InternalError();
		}
	}

	private void writeObject(ObjectOutputStream outputStream) throws IOException {
		outputStream.defaultWriteObject();
		outputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
		outputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
		outputStream.writeInt(map.keySet().size()); //Потребуется при считывании файла (понимание какой обьем надо востановить)
		for (E e : map.keySet()) { //Запись производим по одному элементу
			outputStream.writeObject(e);
		}
	}

	private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
		inputStream.defaultReadObject();
		int capacity = inputStream.readInt();
		float loadFactor = inputStream.readFloat();
		map = new HashMap(capacity, loadFactor);
		int size = inputStream.readInt();
		for (int i = 0; i < size; i++) {
			map.put((E) inputStream.readObject(), PRESENT);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("ddd");
		hashSet.add("rrrr");
		AmigoSet amigoSet = new AmigoSet(hashSet);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream =
				new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(amigoSet);
		objectOutputStream.close();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		AmigoSet amigoSet1 = (AmigoSet) objectInputStream.readObject();
		System.out.println(amigoSet.equals(amigoSet1));
		System.out.println(amigoSet);
		System.out.println("________");
		System.out.println(amigoSet1);
	}
}
