package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ExportadorXml1 implements Exportador {

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {
		PrintWriter out = new PrintWriter(destino);
		out.println("<?xml version=\"1.0\"encoding=UTF8?>");
		out.print("<contas>");

		for (Conta conta: contas) {
			out.printf("\n\t<conta>\n\t\t<cpf>%s</cpf>\n\t\t<banco>%s</banco>\n\t\t<agencia>%s</agencia>\n\t\t<saldo>%.2f</saldo>\n\t</conta>",
					conta.getCpf(), conta.getNumeroDoBanco(), conta.getNumeroDaAgencia(), conta.getSaldoConta()
			);
		}

		out.println("\n</contas>");

		out.close();
	}
}
