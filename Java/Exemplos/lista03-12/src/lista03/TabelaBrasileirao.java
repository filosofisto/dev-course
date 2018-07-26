package lista03;

import static java.lang.System.out;

public class TabelaBrasileirao {

	private ItemTabela[] items;
	private int posicao;
	
	public TabelaBrasileirao() {
		items = new ItemTabela[20];
		posicao = -1;
	}
	
	public void adicionarJogo(Jogo jogo) {
		// Procurar o item do time A
		ItemTabela itemTimeA = procurarItemPorTime(jogo.getTimeA());
		// Atualizar o item conforme resultado do jogo
		atualizarItem(itemTimeA, jogo);
		
		// Procurar o item do time B
		ItemTabela itemTimeB = procurarItemPorTime(jogo.getTimeB());
		// Atualizar o item conforme resultado do jogo
		atualizarItem(itemTimeB, jogo);
		
		// Ordenar a tabela
		// TODO: Implementar
	}
	
	public void exibirResultado() {
		out.println("=============================================");
		out.println("Pos Time            Jog Vit Emp Der Pto GP GC");
		out.println("=============================================");
		
		ItemTabela it;
		
		for (int i = 0; i <= posicao; i++) {
			it = items[i];
			
			out.printf(
					"%d  %s %d  %d  %d  %d  %d  %d  %d\n", 
					i+1,
					it.getTime().getNome(),
					it.getJogos(),
					it.getVitorias(),
					it.getEmpates(),
					it.getDerrotas(),
					it.getPontuacao(),
					it.getGolsPro(),
					it.getGolsSofridos()
			);
		}
	}

	private void atualizarItem(ItemTabela itemTime, Jogo jogo) {
		Time time = itemTime.getTime();
		
		if (jogo.isEmpate()) {
			itemTime.incEmpate();
		} else {
			if (jogo.isVencedor(time)) {
				itemTime.incVitoria();
			} else {
				itemTime.incDerrota();
			}
		}
		
		itemTime.incGolsPro(jogo.getGolsPro(time));
		itemTime.incGolsSofridos(jogo.getGolsSofridos(time));
	}

	private ItemTabela procurarItemPorTime(Time time) {
		ItemTabela itemTabela = null;
		
		for (int i = 0; i <= posicao; i++) {
			if (time.equals(items[i].getTime())) {
				itemTabela = items[i];
				break;
			}
		}
		 
		if (itemTabela == null) {
			itemTabela = new ItemTabela();
			itemTabela.setTime(time);
			
			items[++posicao] = itemTabela;
		}
		
		return itemTabela;
	}
}
