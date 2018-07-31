package lista06;

import java.util.Comparator;

public class NumeroMedalhasComparator implements Comparator<Atleta> {

	@Override
	public int compare(Atleta o1, Atleta o2) {
		
		return o1.getNumeroMedalhas().compareTo(o2.getNumeroMedalhas());
	}
}
