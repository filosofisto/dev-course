package com.javabasico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
	
	private static final int LEN = 10000000;
	
	public static void main(String[] args) {
		Map<Integer, Veiculo> mapVeiculos =
				new HashMap<>();
		List<Veiculo> listVeiculos = new ArrayList<Veiculo>(LEN);
		
		for (int i = 1; i < LEN; i++) {
			Veiculo v = new Veiculo(i);
			mapVeiculos.put(i, v);
			listVeiculos.add(v);
		}
		
		long t1 = System.currentTimeMillis();
		Veiculo ultimo = mapVeiculos.get(LEN);
		long t2 = System.currentTimeMillis();
		
		System.out.printf("Tempo para localizar o item(Map): %dms\n", (t2-t1));
		
		t1 = System.currentTimeMillis();
		/*for (Veiculo v: listVeiculos) {
			if (v.getRenavam().equals(1000000)) {
				break;
			}
		}*/
		Iterator<Veiculo> it = listVeiculos.iterator();
		while (it.hasNext()) {
			if (it.next().equals(LEN)) {
				break;
			}
		}
		t2 = System.currentTimeMillis();
		System.out.printf("Tempo para localizar o item(List): %dms", (t2-t1));
	}
}
