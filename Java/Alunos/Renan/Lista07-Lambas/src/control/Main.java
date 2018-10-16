package control;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.entity.Atleta;
import model.enums.Genero;
import model.enums.Modalidade;
import model.file.EscritaLeitura;

public class Main {
    
    private static final Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {

	try {
	    exercicio05();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	out.println("	Pressione [ENTER] para continuar	...	");
	leitor.nextLine();
	
	try {
	    exercicio06();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    // ==========================================================================================================================================================================================
    // Exercícios
    // ==========================================================================================================================================================================================

    /**
     * Exercíco 05 da Lista 07
     * 
     * @throws IOException
     */
    private static void exercicio05() throws IOException {
	out.println("	Exercício 05 da Lista 07 de Java	");
	out.println(
		"\t\t Dado a classe Atleta que contam as seguintes informações: CPF, Nome, Modalidade e Número de Medalhas, fa�a um programa que leia de um arquivo texto com o seguinte formato CPF (11 caracteres), Nome (30 caracteres), modalidade (20 caracteres) e número de medalhas (3 caracteres numéricos)."
			+ "\n\t A ordenação natural da classe atleta deve ser por nome."
			+ "\n\t Ao ler o arquivo original, gere 4 arquivos, ordenados respectivamente por CPF ascendente, Nome (natural), Modalidade ascendente e Número de Medalhas descendente."
			+ "\n\t Utilize os recursos novos do Java 8." + "\n");

	List<Atleta> atletas = carregarLista();

	// =============================================================================================================

	out.println("\n\n	Interando Lista de " + atletas.size() + " elementos	...	\n");

	atletas.stream().forEach(atleta -> out.println(atleta.toString())); // Imprimindo lista

	// =============================================================================================================

	out.println("\n\n	Escrevendo lista de atletas em arquivo	...	\n");

	EscritaLeitura.escrever(atletas); // Escrevendo em Arquivo

	// =============================================================================================================

	out.println("\n\n	Lendo atletas a partir do arquivo	...	\n");

	atletas = EscritaLeitura.ler(); // Lendo do Arquivo

	// =============================================================================================================

	out.println("\n\n	Interando lista de altetas lidas a partir do arquivo	...	\n");

	atletas.stream().forEach(atleta -> out.println(atleta.toString())); // Imprimindo lista

	// =============================================================================================================

	out.println("\n\n	Criando lista organizada pelo CPF ascendente	...	\n");

	List<Atleta> listaPorCPF = new ArrayList<Atleta>(atletas);
	listaPorCPF.sort((Atleta a1, Atleta a2) -> a1.getCpf().compareTo(a2.getCpf())); // Organizando por CPF

	out.println("\n\n	Lista organizada por CPF ascendente:	\n");
	listaPorCPF.stream().forEach(atleta -> out.println(atleta.toString())); // Imprimindo lista

	// =============================================================================================================

	out.println("\n\n	Criando lista organizada pelo nome ascendente	...	\n");

	List<Atleta> listaPorNome = new ArrayList<Atleta>(atletas);
	listaPorNome.sort((Atleta a1, Atleta a2) -> a1.getNome().compareTo(a2.getNome())); // Organizando por Nome

	out.println("\n\n	Lista organizada por nome ascendente:	\n");
	listaPorNome.stream().forEach(atleta -> out.println(atleta.toString())); // Imprimindo lista

	// =============================================================================================================

	out.println("\n\n	Criando lista organizada por modalidade ascendente	...	\n");

	List<Atleta> listaPorModalidade = new ArrayList<Atleta>(atletas);
	listaPorModalidade.sort((Atleta a1, Atleta a2) -> a1.getModalidade().compareTo(a2.getModalidade())); // Organizando
													     // por
													     // Modalidade
	// Modalidade

	out.println("\n\n	Lista organizada por modalidade ascendente:	\n");
	listaPorModalidade.stream().forEach(atleta -> out.println(atleta.toString())); // Imprimindo lista

	// =============================================================================================================

	out.println("\n\n	Criando lista organizada pelo número de medalhas descendente	...	\n");
	List<Atleta> listaPorMedalhas = new ArrayList<Atleta>(atletas);

	listaPorMedalhas.sort((Atleta a1, Atleta a2) -> {

	    int comp = Integer.compare(a2.getMedalhasDeOuro(), a1.getMedalhasDeOuro());

	    if (comp == 0) {
		comp = Integer.compare(a2.getMedalhasDePrata(), a1.getMedalhasDePrata());

		if (comp == 0)
		    comp = Integer.compare(a2.getMedalhasDeBronze(), a1.getMedalhasDeBronze());
	    }

	    return comp;

	}); // Organizando por Medalhas

	out.println("\n\n	Lista organizada pelo número de medalhas ascendente:	\n");
	listaPorMedalhas.stream().forEach(atleta -> out.println(atleta.toString())); // Imprimindo lista

	// =============================================================================================================

	out.println("\n\n	Escrevendo os arquivos das listas organizadas	...	\n");

	File arquivoPorCPF = new File(System.getProperty("user.dir") + "\\atletas_organizados_por_cpf.txt");
	File arquivoPorNome = new File(System.getProperty("user.dir") + "\\atletas_organizados_por_nome.txt");
	File arquivoPorModalidade = new File(
		System.getProperty("user.dir") + "\\atletas_organizados_por_modalidade.txt");
	File arquivoPorMedalhas = new File(System.getProperty("user.dir") + "\\atletas_organizados_por_medalhas.txt");

	EscritaLeitura.escrever(listaPorCPF, arquivoPorCPF);
	EscritaLeitura.escrever(listaPorNome, arquivoPorNome);
	EscritaLeitura.escrever(listaPorModalidade, arquivoPorModalidade);
	EscritaLeitura.escrever(listaPorMedalhas, arquivoPorMedalhas);

	out.println("\n\n	Os arquivos foram criados em " + System.getProperty("user.dir") + "	\n");

    }
    
    /**
     * Exercício 06 da Lista 07
     */
    private static void exercicio06() {
	out.println("\n\n	Exercício 06 da Lista 07 de Java	\n"
		+ "\t\t Foi identificado pelo corpo técnico de um sistema que diversos comportamentos de operações de banco de dados tais como listagens, inclusões, alterações, exclusões e leituras pela chave primária seguem o mesmo conjunto de comandos Java/JDBC."
		+ "\n\t Baseado neste fato, o Arquiteto da equipe solicitou que para cada operação fosse criado um objeto que o representasse na forma de um Strategy (design pattern GoF)."
		+ "\n\t Implemente os seguintes strategies: Read<T>, List<T>, Create<T>, Update<T> e Delete<T>."
		+ "\n\t Utilize quando possível recursos do Java 8.");
	
	out.println("\n\n	Ainda não feito...	\n");
	
	
    }

    // ==========================================================================================================================================================================================

    private static final Random r = new Random();

    private static List<Atleta> carregarLista() {

	int n = r.nextInt(100) + 3;

	List<Atleta> atletas = new ArrayList<Atleta>();

	do {

	    Atleta a = new Atleta();
	    a.setCpf((r.nextInt(n) + 11111111111L) + "");
	    if (r.nextBoolean())
		a.setGenero(Genero.MASCULINO);
	    else
		a.setGenero(Genero.FEMININO);
	    a.setMedalhasDeBronze(r.nextInt(9));
	    a.setMedalhasDeOuro(r.nextInt(9));
	    a.setMedalhasDePrata(r.nextInt(9));
	    switch (r.nextInt(5)) {
	    case 0:
		a.setModalidade(Modalidade.CORRIDA);
		break;
	    case 1:
		a.setModalidade(Modalidade.FUTEBOL);
		break;
	    case 2:
		a.setModalidade(Modalidade.NATACAO);
		break;
	    case 3:
		a.setModalidade(Modalidade.SALTO);
		break;
	    case 4:
		a.setModalidade(Modalidade.XADREZ);
		break;
	    default:
		break;
	    }
	    a.setNome("Atleta " + r.nextInt(n) + n);

	    out.println("	Atleta criado:	" + a);

	    atletas.add(a);

	    out.println("	Atleta adicionado a lista.	");

	    --n;
	} while (n > 0);

	return atletas;
    }

}
