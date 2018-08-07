package br.org.cpb.cadgeral.controller;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.org.cpb.arquitetura.faces.CRUD;
import br.org.cpb.arquitetura.stereotype.Controller;
import com.cursojava.servico.bean.BancoServicoBean;
import br.org.cpb.cadgeral.lazydatamodel.BancoLazyDataModel;
import com.cursojava.dominio.Banco;


@Controller
@CRUD(
	baseName="Banco",
	beginNavigation="listBancos"
)
public class BancoController extends CRUDController {

	private static final long serialVersionUID = -6199824374371124650L;

	@Inject
	private BancoServicoBean bancoServicoBean;

	@Inject
	private BancoLazyDataModel bancoLazyDataModel;
	
	private Banco banco;
	
	//@PostConstruct
    public String initNovoBanco() {
        banco = new Banco();
        
        return "createBanco";
    }
	
	@Produces
    @Named
    public Banco getBanco() {
        return banco;
    }
	
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	/*@Produces
	@Named
	public List<Banco> getBancos() {
		try {
			return bancoServicoBean.listar();
		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}*/

	@Override
	protected void doCreate() throws Exception {
		bancoServicoBean.incluir(banco);
		initNovoBanco();
		bancoLazyDataModel.invalidateCount();
	}

	@Override
	protected void doUpdate() throws Exception {
		bancoServicoBean.atualizar(banco);
	}

	@Override
	protected void doRead() throws Exception {
	}

	@Override
	protected void doDelete() throws Exception {
		bancoServicoBean.remover(banco);
		bancoLazyDataModel.invalidateCount();
	}
	
	public void salvar() {
		try {
			doSave();
		} catch (Exception e) {
			messageException(e);
		}
	}

	private void doSave() throws Exception {
		if (banco.getId() == null) {
			super.create();
		} else {
			super.update();
		}
	}
	
	protected String ler (){
		try {
			banco = bancoServicoBean.editar(banco);
			
			return "createBanco";

		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}

	public BancoLazyDataModel getBancoLazyDataModel() {
		return bancoLazyDataModel;
	}
}