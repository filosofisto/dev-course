package com.cursojava.util.lazydatamodel;

import com.cursojava.dominio.Banco;
import com.cursojava.servico.BancoServico;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Eduardo on 09/04/2015.
 */
public class BancoLazyDataModel extends SimpleLazyDataModel<Banco> {

	private static final long serialVersionUID = -1905085172862156091L;

	@Inject
    private BancoServico bancoServico;

    @Override
    public Banco getRowData(String rowKey) {
        Long id = new Long(rowKey);

        return bancoServico.obter(id);
    }

    @Override
    public Object getRowKey(Banco banco) {
        return banco.getId();
    }

    @Override
    protected Long calcCount() {
        return bancoServico.count();
    }

    @Override
    protected List<Banco> doQuery(int first, int pageSize) {
        return bancoServico.listar(first, pageSize);
    }
}
