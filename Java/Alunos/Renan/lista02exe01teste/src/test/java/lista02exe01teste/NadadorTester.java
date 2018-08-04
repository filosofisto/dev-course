package lista02exe01teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.CategoriaNatacao;
import model.Nadador;
import model.exception.IdadeNegativaException;
import model.exception.IdadeNulaException;

public class NadadorTester {

	@Test (expected= IdadeNulaException.class)
	public void testarCategoriaIdadeNula() throws Exception{
		Nadador n = new Nadador("Zerado",0);
		
		assertEquals(new IdadeNulaException(), n.getCategoria());
	}
	
	@Test (expected= IdadeNegativaException.class)
	public void testarCategoriaIdadeNegativa() throws Exception{
		Nadador n = new Nadador("Negativo",-1);
		assertEquals(new IdadeNegativaException(), n.getCategoria());
	}
	
	@Test
	public void testarComCategoria() throws Exception {
		Nadador n =  new Nadador("Com categoria", 23);
		assertEquals(true, n.isPossuiCategoria());
	}
	
	@Test
	public void testarSemCategoria() throws Exception {
		Nadador n =  new Nadador("Sem categoria", 3);
		assertEquals(false, n.isPossuiCategoria());
	}
	
	@Test
	public void testarCategoriaInexistente() throws Exception {
		Nadador n =  new Nadador("Bebe", 2);
		assertEquals(null, n.getCategoria());
	}
	
	public void testarCategoriaAdulto() throws Exception {
		Nadador n =  new Nadador("Adulto", 19);
		assertEquals(CategoriaNatacao.ADULTO, n.getCategoria());
	}
	
	@Test
	public void testarCategoriaJuvenilB() throws Exception {
		Nadador n =  new Nadador("Juvenil B", 17);
		assertEquals(CategoriaNatacao.JUVENIL_B, n.getCategoria());
	}
	
	@Test
	public void testarCategoriaJuvenilA() throws Exception {
		Nadador n =  new Nadador("Juvenil A", 13);
		assertEquals(CategoriaNatacao.JUVENIL_A, n.getCategoria());
	}
	
	@Test
	public void testarCategoriaInfantilB() throws Exception {
		Nadador n =  new Nadador("Infantil B", 9);
		assertEquals(CategoriaNatacao.INFANTIL_B, n.getCategoria());
	}
	
	@Test
	public void testarCategoriaInfantilA() throws Exception {
		Nadador n =  new Nadador("Infantil A", 6);
		assertEquals(CategoriaNatacao.INFANTIL_A, n.getCategoria());
	}
	
}
