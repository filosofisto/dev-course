package com.javabasico;

public class ArrayIterator implements Iterator {

	private Object[] array;
	private int current;
	
	public ArrayIterator(Object[] array) {
		this.array = array;
		current = -1;
	}
	
	@Override
	public boolean hasNext() {
		return current < array.length-1;
	}

	@Override
	public Object next() {
		return array[++current];
	}

}
