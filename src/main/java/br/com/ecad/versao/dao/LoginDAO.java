package br.com.ecad.versao.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ecad.versao.model.Login;

@Stateless
public class LoginDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Login buscar(Login login) {
		return em.find(Login.class, login.getLogin());
	}

}
