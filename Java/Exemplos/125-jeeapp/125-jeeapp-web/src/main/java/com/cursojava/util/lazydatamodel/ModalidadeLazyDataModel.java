package com.cursojava.util.lazydatamodel;

import java.util.List;

import javax.inject.Inject;

import com.cursojava.dominio.Modalidade;
import com.cursojava.servico.ModalidadeServico;

public class ModalidadeLazyDataModel extends SimpleLazyDataModel<Modalidade>{

	private static final long serialVersionUID = -2446577358587929842L;

	@Inject
    private ModalidadeServico modalidadeServico;
	
	@Override
    public Modalidade getRowData(String rowKey) {
        Long id = new Long(rowKey);

        return modalidadeServico.obter(id);
    }

    @Override
    public Object getRowKey(Modalidade modalidade) {
        return modalidade.getId();
    }
    
	@Override
	protected Long calcCount() {
		return modalidadeServico.count();
	}

	@Override
	protected List<Modalidade> doQuery(int first, int pageSize) {
		return modalidadeServico.listar(first, pageSize);
	}

}
