package br.com.ecad.versao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

	@Id
	@Column(name = "NOM_LOGIN")
	private String login;
	
	@Column(name = "TXT_NOME")
	private String nome;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
