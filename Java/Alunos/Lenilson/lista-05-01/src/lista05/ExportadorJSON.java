package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorJSON implements Exportador{

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {
		PrintWriter out = new PrintWriter(destino);
		
		out.println("{");
		out.println("\t\"contas\": [");
		
		for (Conta conta: contas) {
			out.printf("\t\t{ \"cpf\":\"%s\", \"banco\":\"%s\", \"agencia\":\"%s\", \"saldo\":%.2f},\n", 
					conta.getCpf(), conta.getBanco(), conta.getAgencia(), conta.getSaldo());
		}
		
		out.println("\t]");
		out.println("}");
		out.close();
		
	}

}
