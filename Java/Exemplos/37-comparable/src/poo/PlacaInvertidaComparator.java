package poo;

import java.util.Comparator;

public class PlacaInvertidaComparator implements Comparator<Automovel> {

	@Override
	public int compare(Automovel o1, Automovel o2) {
		//return -o1.compareTo(o2);
		return -o1.getPlaca().compareTo(o2.getPlaca());
	}

}
