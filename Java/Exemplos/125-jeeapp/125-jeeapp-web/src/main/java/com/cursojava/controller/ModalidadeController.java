package com.cursojava.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.dominio.Modalidade;
import com.cursojava.servico.AeroportoServico;
import com.cursojava.servico.ModalidadeServico;
import com.cursojava.util.lazydatamodel.AeroportoLazyDataModel;
import com.cursojava.util.lazydatamodel.ModalidadeLazyDataModel;


@Named
@ConversationScoped
public class ModalidadeController implements Serializable{

	private static final long serialVersionUID = 170307014898862927L;

	@Inject
	protected Conversation conversation;

	@Inject
	protected FacesContext facesContext;

	@Inject
	private ModalidadeServico modalidadeServico;

	@Inject
	private ModalidadeLazyDataModel modalidadesDataModel;

	private Modalidade modalidade;

	public String begin() {
		conversation.begin();

		return "listaModalidades";
	}

	public String end() {
		conversation.end();

		return "home";
	}

    public Modalidade getModalidade() {
        return modalidade;
    }

    public String novaModalidade() {
	    setModalidade(new Modalidade());

	    return "novaModalidade";
    }

    public void incluir() {
		try {
			modalidadeServico.incluir(modalidade);

			// Prepara para cadastrar outro aeroporto
			setModalidade(new Modalidade());

			messageSucesso("Operação realizada com sucesso");

			modalidadesDataModel.forceRefresh();
		} catch (Exception e) {
			messageException(e);
		}
	}

    public String atualizar() {
		try {
			modalidadeServico.atualizar(modalidade);
			messageSucesso("Operação realizada com sucesso");

			modalidadesDataModel.forceRefresh();

			return "listaModalidades";
		} catch (Exception e) {
			messageException(e);
			return null;
		}
    }

    public String cancelarEdicao() {
        modalidadesDataModel.forceRefresh();

        return "listaModalidades";
    }

	/*@Produces
	@Named
	public List<Modalidade> getModalidades() {
		try {
			return modalidadeServico.listar();
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

	private void messageSucesso(String mensagem) {
		FacesMessage m = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				mensagem, null
		);
		this.facesContext.addMessage(null, m);
	}

    public ModalidadeLazyDataModel getModalidadesDataModel() {
		return modalidadesDataModel;
	}

	public void setModalidadesDataModel(ModalidadeLazyDataModel modalidadesDataModel) {
		this.modalidadesDataModel = modalidadesDataModel;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

}
