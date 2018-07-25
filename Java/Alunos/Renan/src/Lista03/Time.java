package Lista03;

class Time {

	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int gols_pros;
	private int gols_contras;

	public Time() {
	}

	public Time(String nome) {
		this.nome = nome;
	}

	public Time(String nome, int vitorias, int empates, int derrotas) {
		this.nome = nome;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
	}

	public Time(String nome, int vitorias, int empates, int derrotas, int gols_pros, int gols_contra) {
		this.nome = nome;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.gols_pros = gols_pros;
		this.gols_contras = gols_contra;
	}

	public int calcularPontuacao() {
		return this.vitorias * 3 + empates;
	}

	public String toString() {
		return "\t Nome: \t" + this.nome + "\n\t Vitórias: \t" + this.vitorias + "\n\t Empates:  \t" + this.empates
				+ "\n\t Derrotas: \t" + this.derrotas + "\n\t Gols Prós:  \t" + this.gols_pros + "\n\t Gols Contra:\t"
				+ this.gols_contras + "\n\t Pontuação:\t" + this.calcularPontuacao()

		;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getGols_pros() {
		return gols_pros;
	}

	public void setGols_pros(int gols_pros) {
		this.gols_pros = gols_pros;
	}

	public int getGols_contras() {
		return gols_contras;
	}

	public void setGols_contras(int gols_contras) {
		this.gols_contras = gols_contras;
	}
	
	

}
