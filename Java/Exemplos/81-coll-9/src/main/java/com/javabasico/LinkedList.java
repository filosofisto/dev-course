package com.javabasico;

public class LinkedList implements List {

	private Node first;
	private Node last; 
	private int size;
	
	public boolean add(Object object) {
		Node node = new Node(object);
		
		if (first == null) {
			first = node;
			last = node;
		} else {
			Node antigoLast = last;
			antigoLast.setNext(node);
			last = node;
		}
		
		node.setNext(null);
		
		size++;
		
		return true;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void clear() {
		// Garantir que os nodes nao possum referencias, de forma a permitir
		// que o GC possa liberar as respectivas memorias
		Node nodeActual = first;
		Node nodeAux;
		
		while (nodeActual != null) {
			nodeAux = nodeActual.getNext();
			nodeActual.setNext(null);
			nodeActual = nodeAux;
		}
		// ------------------------------------------------------------------
		
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public Object get(int index) {
		int actual = 0;
		Node nodeActual = first;
		
		while (actual < index && nodeActual != null) {
			nodeActual = nodeActual.getNext();
			actual++;
		}
			
		if (nodeActual == null) {
			throw new RuntimeException("Index out of bounds");
		}
		
		return nodeActual.getValue();
	}

	@Override
	public int indexOf(Object elemento) {
		int index = -1;
		Node nodeActual = first;
		
		while (nodeActual != null) {
			if (nodeActual.getValue().equals(elemento)) {
				return ++index;
			}

			nodeActual = nodeActual.getNext();
			index++;
		}

		return index;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		return new ListIterator(this);
	}
}

class Node {
	
	private Object value;
	private Node next;
	
	public Node(Object valor) {
		this.value = valor;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
