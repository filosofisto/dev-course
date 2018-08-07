package br.org.cpb.cadgeral.controller;

import br.org.cpb.arquitetura.faces.CRUD;
import br.org.cpb.arquitetura.stereotype.Controller;
import com.cursojava.servico.AeroportoServico;
import com.cursojava.servico.bean.AeroportoServicoBean;
import br.org.cpb.cadgeral.lazydatamodel.AeroportoLazyDataModel;
import com.cursojava.dominio.Aeroporto;
import org.primefaces.model.LazyDataModel;

import javax.enterprise.inject.Produces;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Controller
@CRUD(
	baseName="Aeroporto",
	beginNavigation="listAeroportos"
)
public class AeroportoController extends CRUDController {

	private static final long serialVersionUID = -5129718892570710240L;

	private static final String BRASIL = "Brasil";

	@Inject
	private AeroportoServico aeroportoServico;

	private Aeroporto aeroporto;

	@Inject
	private AeroportoLazyDataModel aeroportosDataModel;

	@Inject
	private CadastroBasicoServico cadastroBasicoServico;

    public String initNovoAeroporto() {
    	limparControladora();
        aeroporto = new Aeroporto();
        pais = cadastroBasicoServico.buscarBrasilPorNome("Brasil");
        carregarEstados();

        return "createAeroporto";
    }

    public void limparControladora(){
    	setCidade(null);
    	setPais(null);
    	setEstado(null);
    }

	@Produces
    @Named
    public Aeroporto getAeroporto() {
        return aeroporto;
    }

	/*@Produces
	@Named
	public List<Aeroporto> getAeroportos() {
		carregarEstados();
		carregarCidades();
		try {
			return aeroportoServicoBean.listar();
		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}*/

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	@Override
	protected void doCreate() throws Exception {
		aeroporto.setCidade(cidade);
		aeroportoServicoBean.incluir(aeroporto);
		initNovoAeroporto();
		aeroportosDataModel.invalidateCount();
	}

	@Override
	protected void doUpdate() throws Exception {
		aeroportoServicoBean.atualizar(aeroporto);
	}

	@Override
	protected void doRead() throws Exception {
	}

	@Override
	protected void doDelete() throws Exception {
		aeroportoServicoBean.remover(aeroporto);
		aeroportosDataModel.invalidateCount();
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void paisChange(AjaxBehaviorEvent evt) {
		estado = null;
		cidade = null;
		brasil = isBrasil();
		carregarEstados();
		carregarCidades();
	}

	private void carregarEstados() {
		if (getPais() != null) {
			estados = cadastroBasicoServico.listarEstadosPorPais(getPais());
		} else {
			estados = new ArrayList<Estado>();
		}
	}

	public void estadoChange(AjaxBehaviorEvent evt) {
		carregarCidades();
	}

	private void carregarCidades() {
		brasil = isBrasil();
		if (getEstado() != null) {
			cidades = cadastroBasicoServico.listarCidadesPorEstado(getEstado());
		} else {
			if(getPais() != null && brasil == false){
				cidades = cadastroBasicoServico.listarCidadesPorPais(getPais());
			} else {
				cidades = new ArrayList<Cidade>();
			}
		}
	}

	public boolean isBrasil() {
		if (aeroporto != null) {
			if (getPais() != null) {
				brasil = BRASIL.equalsIgnoreCase(getPais().getNome());
			} else {
				brasil = true;
			}
		}

		return brasil;
	}

	public void setBrasil(boolean brasil) {
		this.brasil = brasil;
	}

	public void salvar() {
		try {
			doSave();
		} catch (Exception e) {
			messageException(e);
		}
	}

	private void doSave() throws Exception {
		if (aeroporto.getId() == null) {
			super.create();
		} else {
			super.update();
		}
	}

	protected String ler (){
		try {
			limparControladora();
			aeroporto = aeroportoServicoBean.editar(aeroporto);
			cidade = aeroporto.getCidade();
			pais = aeroporto.getCidade().getPais();
			brasil = isBrasil();

			if (cidade == null) {
				estado = null;
				pais = null;
			} else {
				if(brasil){
					estado = cidade.getEstado();
					if (estado != null) {
						pais = cidade.getPais();
					} else {
						pais = null;
					}
				} else {
					pais = cidade.getPais();
				}
			}
			carregarEstados();
			carregarCidades();

			return "createAeroporto";

		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}

	public LazyDataModel<Aeroporto> getAeroportosDataModel() {
		return aeroportosDataModel;
	}
}