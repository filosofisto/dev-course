package com.cursojava.servico;

import com.cursojava.dominio.Modalidade;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ModalidadeServico {
	
	void incluir(Modalidade modalidade);

    void atualizar(Modalidade modalidade);

    void remover(Modalidade modalidade);

    Modalidade obter(Long id);

    List<Modalidade> listar();

    List<Modalidade> listar(int first, int pageSize);

    long count();

}
