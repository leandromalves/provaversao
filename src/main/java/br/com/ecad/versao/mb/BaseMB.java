package br.com.ecad.versao.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8370796136680691660L;
	
	
	
	public void	exibirMensagemErro(String mensagem){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem,  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void	exibirMensagemAviso(String mensagem){
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	public void	exibirMensagemSucesso(String mensagem){
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	protected FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

}
