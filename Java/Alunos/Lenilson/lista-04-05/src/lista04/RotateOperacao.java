package lista04;

public class RotateOperacao extends Operacao{
	private Operacao[] operacoes;
	
	public RotateOperacao(Operacao[] operacoes) {
		this.operacoes = operacoes;
	}
	
	public void girarExtrato() throws Exception{
		if(operacoes.length < 1) {
			throw new Exception("Não há operações registradas!");
		}
		for (int i = 1; i < operacoes.length; i++) {
			operacoes[i - 1] = operacoes[i];
		}
	}
}
