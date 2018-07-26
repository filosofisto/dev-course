package poo;

public class Main {

	public static void main(String[] args) {
		String x = "";
		
		//Erro de compilacao
		//StringUtil stringUtil = new StringUtil();
		
		if (StringUtil.isEmpty(x)) {
			System.out.println("String vazia");
		} else {
			System.out.println("String preenchida");
		}
		
	}
}
