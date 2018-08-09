package com.cursojava.controller;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.servico.AeroportoServico;
import com.cursojava.util.lazydatamodel.AeroportoLazyDataModel;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    public void incluir() {
		try {
			aeroportoServico.incluir(aeroporto);

			// Prepara para cadastrar outro aeroporto
			setAeroporto(new Aeroporto());

			messageSucesso("Operação realizada com sucesso");

			aeroportosDataModel.forceRefresh();
		} catch (Exception e) {
			messageException(e);
		}
	}

    public String atualizar() {
		try {
			aeroportoServico.atualizar(aeroporto);
			messageSucesso("Operação realizada com sucesso");

			aeroportosDataModel.forceRefresh();

			return "listaAeroportos";
		} catch (Exception e) {
			messageException(e);
			return null;
		}
    }

    public String cancelarEdicao() {
        aeroportosDataModel.forceRefresh();

        return "listaAeroportos";
    }

	public void excluir(Aeroporto aeroporto) {
		try {
			aeroportoServico.remover(aeroporto);
			aeroportosDataModel.forceRefresh();
			messageSucesso("Operação realizada com sucesso");
		} catch (Exception e) {
			messageException(e);
		}
	}

	private void messageException(Exception e) {
		FacesMessage m = new FacesMessage(
				FacesMessage.SEVERITY_ERROR,
				e.getMessage(),
				"Atualização falhou"
		);
		this.facesContext.addMessage(null, m);
		this.facesContext.validationFailed();
	}

	private void messageSucesso(String mensagem) {
		FacesMessage m = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				mensagem, null
		);
		this.facesContext.addMessage(null, m);
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

    public AeroportoLazyDataModel getAeroportosDataModel() {
        return aeroportosDataModel;
    }

    public void setAeroportosDataModel(AeroportoLazyDataModel aeroportosDataModel) {
        this.aeroportosDataModel = aeroportosDataModel;
    }
}