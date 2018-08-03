package model;

import model.exception.IdadeNegativaException;
import model.exception.IdadeNulaException;

public class Nadador extends Pessoa{
	
	public Nadador() {
		
	}
	
	public Nadador(String nome, int idade) {
		super(nome, idade);
	}
	
	public boolean isPossuiCategoria() {
		return this.idade >= 5;
	}
	
	
	public CategoriaNatacao getCategoria() throws Exception {
		if(this.idade >= 18) {
			return CategoriaNatacao.ADULTO;
		}
		if(17 >= this.idade && this.idade >= 14) {
			return CategoriaNatacao.JUVENIL_B;
		}
		if(13 >= this.idade && this.idade >= 11) {
			return CategoriaNatacao.JUVENIL_A;
		}
		if(10 >= this.idade && this.idade >= 8) {
			return CategoriaNatacao.INFANTIL_B;
		}
		if(7 >= this.idade && this.idade >= 5) {
			return CategoriaNatacao.INFANTIL_A;
		}
		if(idade == 0) {
			throw new IdadeNulaException();
		}else if(idade < 0) {
			throw new IdadeNegativaException();
		}
		return null;
	}

	@Override
	public String toString() {
			try {
				return super.toString()+"Nadador [isPossuiCategoria()=" + this.isPossuiCategoria() + ", getCategoria()=" + this.getCategoria() + "]";
			} catch (Exception e) {
				return super.toString()+"Nadador [isPossuiCategoria()=" + this.isPossuiCategoria() + ", getCategoria()="+e+"]";
			}	
	}
	
	

	
}
