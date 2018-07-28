package lista04;

public class Main {

	public static void main(String[] args) {
		
		
		
		//Criação da conta C1
		Conta c1 = new Conta(1500);
		c1.saldoAtual();
		
		//Deposito de R$ 200
		c1.deposita(200);
		c1.saldoAtual();
		
		//Tento sacar R$ 300
		try {
			c1.retira(300);
		} catch (Exception e) {
			System.out.println("Saldo insuficiente!");
		}
		c1.saldoAtual();

		//Criação da conta C2
		Conta c2 = new Conta(2000);
		c2.saldoAtual();
		
		//Transfiro R$ 150 de C1 para C2
		try {
			c1.transfere(150, c2);
		} catch (Exception e) {
			System.out.println("Saldo insuficiente!");
		}
		c1.saldoAtual();
		c2.saldoAtual();
	}

}
