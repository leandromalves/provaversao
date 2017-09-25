package br.com.ecad.versao.dao;

import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.ecad.versao.model.FiltroConsulta;
import br.com.ecad.versao.model.Item;
import br.com.ecad.versao.model.Versao;

@Stateless
public class VersaoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	private static final String QUERY_CONSULTA = "SELECT v from Versao v where 1=1 ";

	public void salvar(Versao versao) {
		em.persist(versao);
	}

	@SuppressWarnings("unchecked")
	public List<Versao> consultar(FiltroConsulta filtro) {
		StringBuilder sb = new StringBuilder(QUERY_CONSULTA);
		
		
		if(filtro.getId() != null) {
			sb.append(" and v.id = :id ");
			return em.createQuery(sb.toString()).setParameter("id", filtro.getId()).getResultList();
		} else {
			boolean possuiFiltroNumVersao = false;
			if(Objects.nonNull(filtro.getNumeroVersao()) 
					&& !filtro.getNumeroVersao().isEmpty()) {
				sb.append(" and v.numeroVersao = :numeroVersao ");
				possuiFiltroNumVersao = true;
			}
			
			if(filtro.getData() != null) {
				sb.append(" and v.data = :data ");
			}
			
			Query query = em.createQuery(sb.toString());
			
			if(possuiFiltroNumVersao) {
				query.setParameter("numeroVersao", filtro.getNumeroVersao());
			}
				
			if(filtro.getData() != null) {
				query.setParameter("data", filtro.getData());
			}
			
			return query.getResultList();
		}
		
	}

	
	
	public void atualizar(Versao versao, List<Item> itemsParaExcluir) {
		em.merge(versao);
		for (Item item : itemsParaExcluir) {
			em.remove(em.contains(item) ? item : em.merge(item));
		}
	}

	
}
