package model.file;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.entity.Atleta;
import model.enums.Modalidade;

public final class EscritaLeitura {

    public static final File arquivoPadrao = new File(System.getProperty("user.dir") + "\\arquivo_"
	    + new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) + ".txt");

    private static final char separador = '|';

    // ==========================================================================================================================================================================================
    // Escrita de Arquivos
    // ==========================================================================================================================================================================================

    public static void escrever(List<Atleta> atletas) {
	escrever(atletas, arquivoPadrao);
    }

    public static void escrever(List<Atleta> atletas, File arquivo) {

	try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))) { // Escritor de Arquivos

	    out.println("	Escrevendo o arquivo	" + arquivo.getCanonicalPath() + "	...	");

	    StringBuilder conteudo = new StringBuilder(); // Conteúdo a ser inserido no arquivo

	    int campo;

	    for (Atleta a : atletas) {

		out.println("	Atleta a ser inserido:	" + a);

		campo = 1;

		do {

		    switch (campo) { // Preenchendo os campos
		    case 1: // CPF
			conteudo.append(adicionarEspaco(a.getCpf(), 11));
			break;
		    case 2: // Nome
			conteudo.append(adicionarEspaco(a.getNome(), 30));
			break;
		    case 3: // Modalidade
			conteudo.append(adicionarEspaco(a.getModalidade().getNome(), 20));
			break;
		    case 4: // Medalhas
			conteudo.append(new String(a.getMedalhasDeOuro() + "").charAt(0)); // Medalha de Ouro
			conteudo.append(separador);
			conteudo.append(new String(a.getMedalhasDePrata() + "").charAt(0)); // Medalha de Prata
			conteudo.append(separador);
			conteudo.append(new String(a.getMedalhasDeBronze() + "").charAt(0)); // Medalha de Bronze
			break;

		    default:
			out.println("	Erro:	Campo não definido para " + campo + "º posição.	");
			break;
		    }

		    conteudo.append(separador);

		    campo++;
		} while (campo <= 4);

		out.println("	Linha a ser escrita:	" + conteudo.toString());

		escritor.write(conteudo.toString()); // Escrevendo a linha
		escritor.newLine(); // Quebra de Linha

		conteudo.setLength(0); // Esvaziando a StringBuilder
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
    // ==========================================================================================================================================================================================
    // Leitura de Arquivos
    // ==========================================================================================================================================================================================

    public static List<Atleta> ler() {
	return ler(arquivoPadrao);
    }

    public static List<Atleta> ler(File arquivo) {

	try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) { // Leitor de Arquivos

	    out.println("	Lendo o arquivo	" + arquivo.getCanonicalPath() + "	...	");

	    List<Atleta> lista = new ArrayList<Atleta>(); // Lista a ser retornada

	    String linha;
	    int n;
	    String campo;

	    while ((linha = leitor.readLine()) != null) { // Lendo linha por linha

		out.println("	Linha lida:	" + linha);

		Atleta a = new Atleta();

		// CPF, Nome, Modalidade, Medalhas

		n = 0;
		campo = linha.substring(n, n + 11);
		out.println("		Campo lido:	"+campo);
		a.setCpf(campo); // CPF
		
		n = 11 + 1; // Próximo
		
		campo = linha.substring(n, n + 30);
		out.println("		Campo lido:	"+campo);
		a.setNome(campo); // Nome
		
		n += 30 + 1; // Próximo
		
		campo = linha.substring(n, n + 20);
		out.println("		Campo lido:	"+campo);
		a.setModalidade(Modalidade.getModalidade(campo)); // Modalidade
		
		n += 20 + 1; // Próximo
		
		campo = linha.substring(n, n + 1);
		out.println("		Campo lido:	"+campo);
		a.setMedalhasDeOuro(Integer.parseInt(campo)); // Medalha de Ouro
		
		n += 1 + 1; // Próximo
		
		campo = linha.substring(n, n + 1);
		out.println("		Campo lido:	"+campo);
		a.setMedalhasDePrata(Integer.parseInt(campo)); // Medalha de Prata
		
		n += 1 + 1; // Próximo
		
		campo = linha.substring(n, n + 1);
		out.println("		Campo lido:	"+campo);
		a.setMedalhasDeBronze(Integer.parseInt(campo)); // Medalha de Bronze

		out.println("	Atleta lido:	" + a);

		lista.add(a); // Adicionando atleta lido

	    }

	    return lista;

	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    // ==========================================================================================================================================================================================
    // Ajustes de Campo
    // ==========================================================================================================================================================================================

    private static String adicionarEspaco(String texto, int novoTamanho) {

	StringBuilder sb = new StringBuilder(texto);

	if (novoTamanho > texto.length())
	    while (sb.length() < novoTamanho)
		sb.append(" ");

	return sb.toString().substring(0, novoTamanho);
    }

}
