package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorXML2 implements Exportador{

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {
		PrintWriter out = new PrintWriter(destino);
		
		out.println("<?xml version=”1.0” encoding=”UTF-8”?>");
		out.println("<contas>");
		
		for (Conta conta: contas) {
			out.printf("\t<conta cpf=\"%s\" banco=\"%s\" agencia=\"%s\" saldo=\"%.2f\"/>\n", 
					conta.getCpf(), conta.getBanco(), conta.getAgencia(), conta.getSaldo());
		}
		
		out.println("</contas>");
		out.close();
		
	}

}
