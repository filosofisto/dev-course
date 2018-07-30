package com.javabasico;

public class ArrayList implements List {

	private Object[] array;
	private int free;
	private int size;
	
	public ArrayList() {
		array = new Object[100];
		free = 0;
		size = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.javabasico.List#add(java.lang.Object)
	 */
	@Override
	public boolean add(Object elemento) {
		size++;
		
		if (free < array.length) {
			array[free++] = elemento;
			return true;
		} else {
			aumentaCapacidade();
			return add(elemento);
		}
	}

	/* (non-Javadoc)
	 * @see com.javabasico.List#clear()
	 */
	@Override
	public void clear() {
		array = new Object[100];
		free = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.javabasico.List#get(int)
	 */
	@Override
	public Object get(int index) {
		return array[index];
	}

	/* (non-Javadoc)
	 * @see com.javabasico.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object elemento) {
		for (int i = 0; i < free; i++) {
			if (elemento.equals(array[i])) {
				return i;
			}
		}
		
		return -1;
 	}

	/* (non-Javadoc)
	 * @see com.javabasico.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return free == 0;
	}
	
	private void aumentaCapacidade() {
		Object[] newArray = new Object[array.length*2];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		array = newArray;
	}

	@Override
	public int size() {
		return size;
	}
}
