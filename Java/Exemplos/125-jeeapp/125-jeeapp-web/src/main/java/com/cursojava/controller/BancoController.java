package com.cursojava.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.dominio.Banco;
import com.cursojava.servico.BancoServico;
import com.cursojava.util.lazydatamodel.BancoLazyDataModel;

@Named
@ConversationScoped
public class BancoController implements Serializable {

	private static final long serialVersionUID = -6199824374371124650L;

	@Inject
	private BancoServico bancoServico;

	@Inject
	protected Conversation conversation;

	@Inject
	protected FacesContext facesContext;

	@Inject
	private BancoLazyDataModel bancoLazyDataModel;

	private Banco banco;

	public String begin() {
		conversation.begin();

		return "listaBancos";
	}

	public String novoBanco() {
		setBanco(new Banco());

		return "novoBanco";
	}

	@Produces
	@Named
	public List<Banco> getBancos() {
		try {
			return bancoServico.listar();
		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}

	public void incluir() {
		try {
			bancoServico.incluir(banco);

			setBanco(new Banco());

			messageSucesso("Operação realizada com sucesso");

			bancoLazyDataModel.forceRefresh();
		} catch (Exception e) {
			messageException(e);
		}
	}

	public String atualizar() {
		try {
			bancoServico.atualizar(banco);
			messageSucesso("Operação realizada com sucesso");

			bancoLazyDataModel.forceRefresh();

			return "listaBancos";
		} catch (Exception e) {
			messageException(e);
			return null;
		}
	}

	public String cancelarEdicao() {
		bancoLazyDataModel.forceRefresh();

		return "listaBancos";
	}

	// @Override
	// protected void doUpdate() throws Exception {
	// bancoServico.atualizar(banco);
	// }
	//
	// @Override
	// protected void doRead() throws Exception {
	// }
	//
	// @Override
	// protected void doDelete() throws Exception {
	// bancoServico.remover(banco);
	// bancoLazyDataModel.forceRefresh();
	// }

	private void messageException(Exception e) {
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Atualização falhou");
		this.facesContext.addMessage(null, m);
		this.facesContext.validationFailed();
	}

	private void messageSucesso(String mensagem) {
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		this.facesContext.addMessage(null, m);
	}

	// protected String ler() {
	// try {
	// banco = bancoServico.obter(banco.getId());
	//
	// return "createBanco";
	//
	// } catch (Exception e) {
	// messageException(e);
	// return null;
	// }
	// }

	public BancoLazyDataModel getBancoLazyDataModel() {
		return bancoLazyDataModel;
	}

	public void setBancoLazyDataModel(BancoLazyDataModel bancoLazyDataModel) {
		this.bancoLazyDataModel = bancoLazyDataModel;
	}

	@Produces
	@Named
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}