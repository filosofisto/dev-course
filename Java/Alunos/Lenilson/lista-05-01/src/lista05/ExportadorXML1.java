package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorXML1 implements Exportador{

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {
		PrintWriter out = new PrintWriter(destino);
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<contas>");
		
		for (Conta conta: contas) {
			out.println("\t<conta>");
			out.printf("\t\t<cpf>%s</cpf>\n", conta.getCpf());
			out.printf("\t\t<banco>%s</banco>\n", conta.getBanco());
			out.printf("\t\t<agencia>%s</agencia>\n", conta.getAgencia());
			out.printf("\t\t<saldo>%.2f</saldo>\n", conta.getSaldo());
			out.println("\t</conta>");
		}
		
		out.println("</contas>");
		out.close();
		
	}

}
