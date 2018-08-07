package br.org.cpb.cadgeral.lazydatamodel;

import java.util.List;

import javax.inject.Inject;

import br.org.cpb.arquitetura.faces.SimpleLazyDataModel;
import com.cursojava.servico.bean.AeroportoServicoBean;
import com.cursojava.dominio.Aeroporto;

/**
 * Created by Eduardo on 09/04/2015.
 */
public class AeroportoLazyDataModel extends SimpleLazyDataModel<Aeroporto> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3755377974082724830L;
	@Inject
    private AeroportoServicoBean aeroportoServicoBean;

    @Override
    public Aeroporto getRowData(String rowKey) {
        Long id = new Long(rowKey);

        return aeroportoServicoBean.obter(id);
    }

    @Override
    public Object getRowKey(Aeroporto aeroporto) {
        return aeroporto.getId();
    }

    @Override
    protected Long calcCount() {
        return aeroportoServicoBean.count();
    }

    @Override
    protected List<Aeroporto> doQuery(int first, int pageSize) {
        return aeroportoServicoBean.listar(first, pageSize);
    }
}
