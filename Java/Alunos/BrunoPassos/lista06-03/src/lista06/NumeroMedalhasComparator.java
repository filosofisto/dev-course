package lista06;

import java.util.Comparator;

public class NumeroMedalhasComparator implements Comparator<Atleta> {

	@Override
	public int compare(Atleta o1, Atleta o2) {
		int ret = o2.getNumeroMedalhas()-o1.getNumeroMedalhas();

		if (ret == 0) {
			ret = o1.compareTo(o2);
		}

		return ret;
	}
}
