package control;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;
import model.CadastroLivro;
import model.Livro;

public class Main {

	public static void main(String[] args) {

		Random r = new Random();

		int n = r.nextInt(25) + 10;

		CadastroLivro cl = new CadastroLivro();

		while (n > 0) {
			--n;

			cl.adicionarLivro(new Livro("autor "+r.nextInt(n+1),"titulo "+ r.nextInt(n+1),""+r.nextInt((n+1))));

		}

		out.println(cl.toString());
		out.println("Livros na Coleção: "+cl.getQuantidadeDeLivros());
		
		out.print("\n\n Insira o ISBN do livro que gostaria de remover: ");
		
		
		Scanner in = new Scanner(System.in);
		
		String ISBN =  in.nextLine();
		
		if(cl.obterLivroPorISBN(ISBN) != null) {
			out.println("Achado!");
		}else {
			out.println("Não existe!");
		}
		
		cl.removerLivro(ISBN);
		
		
		out.println(cl.toString());
		out.println("Livros na Coleção: "+cl.getQuantidadeDeLivros());

	}

}
