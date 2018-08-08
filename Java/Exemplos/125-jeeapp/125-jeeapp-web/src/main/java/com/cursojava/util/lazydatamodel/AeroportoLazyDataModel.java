package com.cursojava.util.lazydatamodel;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.servico.AeroportoServico;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Eduardo on 09/04/2015.
 */
public class AeroportoLazyDataModel extends SimpleLazyDataModel<Aeroporto> {

	private static final long serialVersionUID = 3755377974082724830L;

	@Inject
    private AeroportoServico aeroportoServico;

    @Override
    public Aeroporto getRowData(String rowKey) {
        Long id = new Long(rowKey);

        return aeroportoServico.obter(id);
    }

    @Override
    public Object getRowKey(Aeroporto aeroporto) {
        return aeroporto.getId();
    }

    @Override
    protected Long calcCount() {
        return aeroportoServico.count();
    }

    @Override
    protected List<Aeroporto> doQuery(int first, int pageSize) {
        return aeroportoServico.listar(first, pageSize);
    }

}
