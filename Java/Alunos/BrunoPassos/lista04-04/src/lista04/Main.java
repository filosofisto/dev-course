package lista04;

public class Main {

	public static void main(String[] args) {

		Conta conta = new Conta(1232, 1122);		
		Conta conta2 = new Conta(1111, 2332);	
	
		try {
			conta.deposita(-10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
