package poo;

import java.util.Comparator;

public class Ordenator {

	public static <T extends Comparable<T>> void sort(T[] array) {
		int n = array.length;
		
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}
	
	public static <T> void sort(T[] array, Comparator<T> c) {
		int n = array.length;
		
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (c.compare(array[j], array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}
}
