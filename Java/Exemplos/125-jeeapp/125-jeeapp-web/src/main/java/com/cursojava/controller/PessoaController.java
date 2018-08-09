package com.cursojava.controller;

import com.cursojava.dominio.Pessoa;
/*import com.cursojava.servico.pessoaServico;
import com.cursojava.util.lazydatamodel.pessoaLazyDataModel;*/
import com.cursojava.servico.PessoaServico;
import com.cursojava.util.lazydatamodel.PessoaLazyDataModel;

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
public class PessoaController implements Serializable {

	private static final long serialVersionUID = -5129718892570710240L;

	private static final PessoaLazyDataModel PessoasDataModel = null;

	@Inject
	protected Conversation conversation;

	@Inject
	protected FacesContext facesContext;

	@Inject
	private PessoaServico pessoaServico;

	@Inject
	private PessoaLazyDataModel pessoaDataModel;

	private Pessoa pessoa;

	public String begin() {
		conversation.begin();

		return "listaPessoas";
	}

	public String end() {
		conversation.end();

		return "home";
	}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String novoPessoa() {
	    setPessoa(new Pessoa());

	    return "novoPessoa";
    }

    public void incluir() {
		try {
			pessoaServico.incluir(pessoa);

			// Prepara para cadastrar outro pessoa
			setPessoa(new Pessoa());

			messageSucesso("Operação realizada com sucesso");

			pessoaDataModel.forceRefresh();
		} catch (Exception e) {
			messageException(e);
		}
	}

    public String atualizar() {
		try {
			pessoaServico.atualizar(pessoa);
			messageSucesso("Operação realizada com sucesso");

			pessoaDataModel.forceRefresh();

			return "listapessoas";
		} catch (Exception e) {
			messageException(e);
			return null;
		}
    }

    public String cancelarEdicao() {
        pessoaDataModel.forceRefresh();

        return "listapessoas";
    }

	@Produces
	@Named
	public List<Pessoa> getpessoas() {
		try {
			return pessoaServico.listar();
		} catch (Exception e) {
			messageException(e);
			return null;
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

	public void setPessoa(Pessoa Pessoa) {
		this.pessoa = Pessoa;
	}

    public PessoaLazyDataModel getPessoasDataModel() {
        return PessoasDataModel;
    }

    public void setPessoasDataModel(PessoaLazyDataModel PessoasDataModel) {
        this.pessoaDataModel = PessoasDataModel;
    }
	
}