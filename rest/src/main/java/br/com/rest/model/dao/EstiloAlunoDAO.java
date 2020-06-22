package br.com.rest.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.rest.model.entity.EstiloAlunoEntity;

public class EstiloAlunoDAO extends GenericDAO<EstiloAlunoEntity>{
	
	private static EstiloAlunoDAO instance = null;
	
	private EstiloAlunoDAO() {
		super(EstiloAlunoEntity.class, PersistenceManager.getEntityManager());
	}
	
	public synchronized static EstiloAlunoDAO getInstance() {
		if(instance == null) {
			instance = new EstiloAlunoDAO();
		}
		return instance;
	}
	
	public List<EstiloAlunoEntity> dynamicQueryFiltro(String matricula, Date startDate, Date endDate, String nivel, String turma) {
		em.clear();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<EstiloAlunoEntity> query = cb.createQuery(EstiloAlunoEntity.class);
		Root<EstiloAlunoEntity> root = query.from(EstiloAlunoEntity.class);
		
		query.select(root);
		if(matricula != null) {
			query.where(cb.equal(root.get("aluno").get("matricula"), matricula));
		} else {
			
		}
		
		TypedQuery<EstiloAlunoEntity> typedQuery = em.createQuery(query);
		List<EstiloAlunoEntity> retorno = new ArrayList<EstiloAlunoEntity>();
		if(matricula != null) {
			retorno.add(typedQuery.getSingleResult());
		} else {
			retorno = typedQuery.getResultList();
		}
		
		em.close();
		
		return retorno;
	}
	 
}
