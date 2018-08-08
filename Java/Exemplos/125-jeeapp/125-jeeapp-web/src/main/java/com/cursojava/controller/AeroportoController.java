package com.cursojava.controller;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.servico.AeroportoServico;
import com.cursojava.util.lazydatamodel.AeroportoLazyDataModel;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
public class AeroportoController implements Serializable {

	private static final long serialVersionUID = -5129718892570710240L;

	@Inject
	protected Conversation conversation;

	@Inject
	protected FacesContext facesContext;

	@Inject
	private AeroportoServico aeroportoServico;

	@Inject
	private AeroportoLazyDataModel aeroportosDataModel;

	private Aeroporto aeroporto;

	public String begin() {
		conversation.begin();

		return "listaAeroportos";
	}

	public String end() {
		conversation.end();

		return "home";
	}

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public String novoAeroporto() {
	    setAeroporto(new Aeroporto());

	    return "novoAeroporto";
    }

    public String salvar() {
	    if (aeroporto.getId() != null) {
            aeroportoServico.atualizar(aeroporto);
        } else {
	        aeroportoServico.incluir(aeroporto);
        }

        aeroportosDataModel.forceRefresh();

        return "listaAeroportos";
    }

    public String cancelarEdicao() {
        aeroportosDataModel.forceRefresh();

        return "listaAeroportos";
    }

	/*@Produces
	@Named
	public List<Aeroporto> getAeroportos() {
		try {
			return aeroportoServico.listar();
		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}*/

	private void messageException(Exception e) {
		FacesMessage m = new FacesMessage(
				FacesMessage.SEVERITY_ERROR,
				e.getMessage(),
				"Atualização falhou"
		);
		this.facesContext.addMessage(null, m);
		this.facesContext.validationFailed();
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	public void incluir() {
		try {
			aeroportoServico.incluir(aeroporto);

			//TODO: Mensagem de sucesso
		} catch (Exception e) {
			messageException(e);
		}
	}

    public AeroportoLazyDataModel getAeroportosDataModel() {
        return aeroportosDataModel;
    }

    public void setAeroportosDataModel(AeroportoLazyDataModel aeroportosDataModel) {
        this.aeroportosDataModel = aeroportosDataModel;
    }
}