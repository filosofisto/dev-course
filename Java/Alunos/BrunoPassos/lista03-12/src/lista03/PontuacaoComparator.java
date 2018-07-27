package lista03;

import java.util.Comparator;

public class PontuacaoComparator implements Comparator<ItemTabela>{

	@Override
	public int compare(ItemTabela o1, ItemTabela o2) {
		return o1.compareTo(o2);
	}

}
