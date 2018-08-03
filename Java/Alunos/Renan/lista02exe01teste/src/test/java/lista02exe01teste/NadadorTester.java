package lista02exe01teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.CategoriaNatacao;
import model.Nadador;
import model.exception.IdadeNegativaException;
import model.exception.IdadeNulaException;

public class NadadorTester {

	@Test (expected= IdadeNulaException.class)
	void testarCategoriaIdadeNula(){
		Nadador n = new Nadador("Zerado",0);
		try {
		assertEquals(new IdadeNulaException(), n.getCategoria());
		}catch(Exception e) {
			assertEquals(new IdadeNulaException(), e);	
		}
	}
	
	@Test (expected= IdadeNegativaException.class)
	void testarCategoriaIdadeNegativa(){
		Nadador n = new Nadador("Negativo",-1);
		try {
			assertEquals(new IdadeNegativaException(), n.getCategoria());
		} catch (Exception e) {
			assertEquals(new IdadeNegativaException(), e);	
		}
	}
	
	@Test
	void testarComCategoria() throws Exception {
		Nadador n =  new Nadador("Com categoria", 23);
		assertEquals(true, n.isPossuiCategoria());
	}
	
	@Test (expected= NullPointerException.class)
	void testarSemCategoria() throws Exception {
		Nadador n =  new Nadador("Sem categoria", 3);
		assertEquals(false, n.isPossuiCategoria());
	}
	
	@Test
	void testarCategoriaInexistente() throws Exception {
		Nadador n =  new Nadador("Bebe", 2);
		assertEquals(null, n.getCategoria());
	}
	
	@Test
	void testarCategoriaAdulto() throws Exception {
		Nadador n =  new Nadador("Adulto", 19);
		assertEquals(CategoriaNatacao.ADULTO, n.getCategoria());
	}
	
	@Test
	void testarCategoriaJuvenilB() throws Exception {
		Nadador n =  new Nadador("Juvenil B", 17);
		assertEquals(CategoriaNatacao.JUVENIL_B, n.getCategoria());
	}
	
	@Test
	void testarCategoriaJuvenilA() throws Exception {
		Nadador n =  new Nadador("Juvenil A", 13);
		assertEquals(CategoriaNatacao.JUVENIL_A, n.getCategoria());
	}
	
	@Test
	void testarCategoriaInfantilB() throws Exception {
		Nadador n =  new Nadador("Infantil B", 11);
		assertEquals(CategoriaNatacao.INFANTIL_B, n.getCategoria());
	}
	
	@Test
	void testarCategoriaInfantilA() throws Exception {
		Nadador n =  new Nadador("Infantil A", 6);
		assertEquals(CategoriaNatacao.INFANTIL_A, n.getCategoria());
	}
	
	

}
