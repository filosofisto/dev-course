package com.cursojava.controller;

import com.cursojava.dominio.Aeroporto;
/*import com.cursojava.servico.pessoaServico;
import com.cursojava.util.lazydatamodel.AeroportoLazyDataModel;*/

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ConversationScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = -5129718892570710240L;

	@Inject
	protected Conversation conversation;

	@Inject
	protected FacesContext facesContext;

	/*@Inject
	private PessoaServico pessoaServico;

	@Inject
	private PessoaLazyDataModel pessoaDataModel;

	private Pessoa pessoa;*/

	public String begin() {
		conversation.begin();

		return "listaPessoas";
	}

	public String end() {
		conversation.end();

		return "home";
	}

   /* public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public String novoAeroporto() {
	    setAeroporto(new Aeroporto());

	    return "novoPessoa";
    }*/

    /*public void incluir() {
		try {
			pessoaServico.incluir(aeroporto);

			// Prepara para cadastrar outro aeroporto
			setAeroporto(new Aeroporto());

			messageSucesso("Operação realizada com sucesso");

			pessoaDataModel.forceRefresh();
		} catch (Exception e) {
			messageException(e);
		}
	}*/

    /*public String atualizar() {
		try {
			pessoaServico.atualizar(aeroporto);
			messageSucesso("Operação realizada com sucesso");

			pessoaDataModel.forceRefresh();

			return "listaAeroportos";
		} catch (Exception e) {
			messageException(e);
			return null;
		}
    }*/

    /*public String cancelarEdicao() {
        pessoaDataModel.forceRefresh();

        return "listaAeroportos";
    }*/

	/*@Produces
	@Named
	public List<Aeroporto> getAeroportos() {
		try {
			return pessoaServico.listar();
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

}