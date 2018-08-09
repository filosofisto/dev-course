package com.cursojava.util.lazydatamodel;

import com.cursojava.dominio.Pessoa;
import com.cursojava.servico.PessoaServico;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Eduardo on 09/04/2015.
 */
public class PessoaLazyDataModel extends SimpleLazyDataModel<Pessoa> {

	private static final long serialVersionUID = 3755377974082724830L;

	@Inject
    private PessoaServico PessoaServico;

    @Override
    public Pessoa getRowData(String rowKey) {
        Long id = new Long(rowKey);

        return PessoaServico.obter(id);
    }

    @Override
    public Object getRowKey(Pessoa Pessoa) {
        return Pessoa.getId();
    }

    @Override
    protected Long calcCount() {
        return PessoaServico.count();
    }

    @Override
    protected List<Pessoa> doQuery(int first, int pageSize) {
        return PessoaServico.listar(first, pageSize);
    }

}
