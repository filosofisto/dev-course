package com.javabasico;

public class Main {
	
	public static void main(String[] args) {
		/*List list = new LinkedList();
		
		list.add("Eduardo");
		list.add("Danillo");
		list.add("Renan");
		list.add("Lenilson");
		list.add("Bruno");

		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		String[] arr = {
			"Eduardo",
			"Danillo",
			"Renan",
			"Lenilson",
			"Bruno"
		};
		
		Iterator it = new ArrayIterator(arr);
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
