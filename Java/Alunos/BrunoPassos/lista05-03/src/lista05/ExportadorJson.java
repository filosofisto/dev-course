package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorJson implements Exportador {

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {

		PrintWriter out = new PrintWriter(destino);
		
		/*
		 * cabecalho:
		 * 
		 * { ?propriedade?: ?valor?, ?propriedade?: { ?propriedade?: ?valor? }}
		 */
		out.println("\t{");
		out.println("\t\t\"contas\":[");
		
		/*
		 * { ?cpf?: ?81646674987?, ?banco?: ?001?, ?agencia?: ?12121?, ?saldo?: 3123123 },
		 */
		for(Conta conta: contas) {
			out.printf("\t\t\t{\"cpf\":\"%s\", \"banco\": \"%s\", \"agencia\": \"%s\", \"saldo\": %.2f},\n", // resolver as virgulas
					conta.getCpf(), conta.getNumeroDoBanco(), conta.getNumeroDaAgencia(), conta.getSaldoConta());
		}
		out.println("\t\t]");
		out.println("\t}");
		out.close();
	}

}
