package lista03;

public class ItemTabela implements Comparable<ItemTabela>{

	private Time time;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int golsPro;
	private int golsSofridos;
	
	public int getJogos() {
		return vitorias+derrotas+empates;
	}
	
	public int getPontuacao() {
		return vitorias*3+empates;
	}
	
	public int getSaldoGols() {
		return golsPro-golsSofridos;
	}
	
	public int getVitorias() {
		return vitorias;
	}
	
	public int getDerrotas() {
		return derrotas;
	}
	
	public int getEmpates() {
		return empates;
	}
	
	public int getGolsPro() {
		return golsPro;
	}
	
	public int getGolsSofridos() {
		return golsSofridos;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
	
	public void incEmpate() {
		empates++;
	}
	
	public void incVitoria() {
		vitorias++;
	}
	
	public void incDerrota() {
		derrotas++;
	}
	
	public void incGolsPro(int gols) {
		golsPro += gols; 
	}
	
	public void incGolsSofridos(int gols) {
		golsSofridos += gols;
	}

	@Override
	public int compareTo(ItemTabela o) {
		int ret = o.getPontuacao()-getPontuacao();
		
		if (ret == 0) {
			ret = o.getVitorias()-getVitorias();
		}
		
		return ret;
	}
}
