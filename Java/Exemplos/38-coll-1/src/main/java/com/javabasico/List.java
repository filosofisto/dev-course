package com.javabasico;

public interface List {

	boolean add(Object elemento);

	void clear();

	Object get(int index);

	int indexOf(Object elemento);

	boolean isEmpty();

	int size();
}