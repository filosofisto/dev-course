package br.org.cpb.cadgeral.lazydatamodel;

import java.util.List;

import javax.inject.Inject;

import br.org.cpb.arquitetura.faces.SimpleLazyDataModel;
import com.cursojava.servico.bean.BancoServicoBean;
import com.cursojava.dominio.Banco;

/**
 * Created by Eduardo on 09/04/2015.
 */
public class BancoLazyDataModel extends SimpleLazyDataModel<Banco> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1905085172862156091L;
	@Inject
    private BancoServicoBean bancoServicoBean;

    @Override
    public Banco getRowData(String rowKey) {
        Long id = new Long(rowKey);

        return bancoServicoBean.obter(id);
    }

    @Override
    public Object getRowKey(Banco banco) {
        return banco.getId();
    }

    @Override
    protected Long calcCount() {
        return bancoServicoBean.count();
    }

    @Override
    protected List<Banco> doQuery(int first, int pageSize) {
        return bancoServicoBean.listar(first, pageSize);
    }
}
