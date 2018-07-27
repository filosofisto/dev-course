package enum_teste;

public enum DiaDaSemana {
	DOMINGO(1), SEGUNDA(2), TERCA(3), QUARTA(4), QUINTA(5), SEXTA(6), SABADO(7);
	
	private int ordem;
	
	DiaDaSemana(int ordem){
		this.ordem= ordem;
	}

}
