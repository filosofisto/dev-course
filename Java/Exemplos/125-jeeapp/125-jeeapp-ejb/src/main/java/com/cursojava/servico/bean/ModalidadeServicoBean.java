package com.cursojava.servico.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.cursojava.dominio.Modalidade;
import com.cursojava.repositorio.ModalidadeRepositorio;
import com.cursojava.servico.ModalidadeServico;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ModalidadeServicoBean implements ModalidadeServico, Serializable{

	@Inject
    private Logger log;

    @Inject
    private ModalidadeRepositorio modalidadeRepositorio;
	
	@Override
	public void incluir(Modalidade modalidade) {
		log.info("Incluindo nova modalidade");
        modalidadeRepositorio.insert(modalidade);
        log.info("Modalidade incluida com sucesso");
	}

	@Override
	public void atualizar(Modalidade modalidade) {
		log.info("Atualizando modalidade " + modalidade.getId());
        modalidadeRepositorio.update(modalidade);
        log.info("Modalidade atualizada com sucesso");
	}

	@Override
	public void remover(Modalidade modalidade) {
		log.info("Removendo modalidade " + modalidade.getId());
        modalidadeRepositorio.remove(modalidade);
        log.info("Modalidade removida com sucesso");
	}

	@Override
	public Modalidade obter(Long id) {
		log.info("Obtendo modalidade " + id);
        return modalidadeRepositorio.find(id);
	}

	@Override
	public List<Modalidade> listar() {
		return modalidadeRepositorio.listar();
	}

	@Override
	public List<Modalidade> listar(int first, int pageSize) {
		return modalidadeRepositorio.listar(first, pageSize);
	}

	@Override
	public long count() {
		return modalidadeRepositorio.count();
	}

}
