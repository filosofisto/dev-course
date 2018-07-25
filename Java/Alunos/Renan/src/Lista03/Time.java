package Lista03;

class Time {

	String nome;
	int vitorias;
	int empates;
	int derrotas;
	int gols_pros;
	int gols_contras;

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

	public Time(String nome, int vitorias, int empates, int derrotas,
			int gols_pros, int gols_contra) {
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
		return " Nome: \t"+this.nome
				+"\n Vitórias: \t"+this.vitorias
				+"\n Empates:  \t"+this.empates
				+"\n Derrotas: \t"+this.derrotas
				+"\n Gols Prós:   \t"+this.gols_pros
				+"\n Gols Contra: \t"+this.gols_contras
						
						;
	}

}
