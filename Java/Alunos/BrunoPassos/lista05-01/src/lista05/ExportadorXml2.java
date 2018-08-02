package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorXml2 implements Exportador {

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {

		PrintWriter out = new PrintWriter(destino);
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<contas>");
		
			for(Conta conta: contas) {
				out.printf("\t<conta cpf=\"%s\" banco=\"%s\" agencia=\"%s\" saldo=\"%.2f\"/>\n", 
						conta.getCpf(), conta.getNumeroDoBanco(), conta.getNumeroDaAgencia(), conta.getSaldoConta());
			}
		
		
		out.println("</contas>");
		out.close();
	}

}
