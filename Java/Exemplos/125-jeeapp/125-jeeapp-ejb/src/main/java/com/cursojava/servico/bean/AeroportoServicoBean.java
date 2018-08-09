package com.cursojava.servico.bean;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.repositorio.AeroportoRepositorio;
import com.cursojava.servico.AeroportoServico;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AeroportoServicoBean implements AeroportoServico, Serializable {

    @Inject
    private Logger log;

    @Inject
    private AeroportoRepositorio aeroportoRepositorio;

    @Override
    public void incluir(Aeroporto aeroporto) {
        log.info("Incluindo novo aeroporto");
        aeroportoRepositorio.insert(aeroporto);
        log.info("Aeroporto incluido com sucesso");
    }

    @Override
    public void atualizar(Aeroporto aeroporto) {
        log.info("Atualizando aeroporto " + aeroporto.getId());
        aeroportoRepositorio.update(aeroporto);
        log.info("Aeroporto atualizado com sucesso");
    }

    @Override
    public void remover(Aeroporto aeroporto) {
        log.info("Removendo aeroporto " + aeroporto.getId());
        aeroportoRepositorio.removeByKey(aeroporto.getId());
        log.info("Aeroporto removido com sucesso");
    }

    @Override
    public Aeroporto obter(Long id) {
        log.info("Obtendo aeroporto " + id);
        return aeroportoRepositorio.find(id);
    }

    @Override
    public List<Aeroporto> listar() {
        return aeroportoRepositorio.listar();
    }

    @Override
    public List<Aeroporto> listar(int first, int pageSize) {
        return aeroportoRepositorio.listar(first, pageSize);
    }

    @Override
    public long count() {
        return aeroportoRepositorio.count();
    }
}
