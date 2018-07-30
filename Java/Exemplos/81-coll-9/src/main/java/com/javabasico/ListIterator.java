package com.javabasico;

public class ListIterator implements Iterator {

	private List list;
	private int current;
	
	public ListIterator(List list) {
		this.list = list;
		current = -1;
	}
	
	@Override
	public boolean hasNext() {
		return current < list.size()-1;
	}

	@Override
	public Object next() {
		return list.get(++current);
	}

}
