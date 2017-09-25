package br.com.ecad.versao.mb;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecad.versao.dao.LoginDAO;
import br.com.ecad.versao.model.Login;

@Named
@SessionScoped
public class LoginMB extends BaseMB {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private LoginDAO dao;
	
	private Login login = new Login();
	
	public void efetuarLogin() {
		login = dao.buscar(login);
		
		if(login == null) {
			 exibirMensagemAviso("Usuario não existe");
			 return;
		}
		
	}
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

}
