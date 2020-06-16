package br.com.rest.model.dao;

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
	/*
	public EstiloAlunoEntity dynamicQuery(String matricula) {
		em.clear();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EstiloAlunoEntity> query = cb.createQuery(EstiloAlunoEntity.class);
		Root<EstiloAlunoEntity> estiloAluno = query.from(EstiloAlunoEntity.class);
		query.select(estiloAluno)
			.where(cb.gt(estiloAluno.get(EstiloAlunoEntity_.), 3000d));
		TypedQuery<Employee> typedQuery = em.createQuery(query);
		typedQuery.getResultList()
            .forEach(System.out::println);
  em.close();
		
		return estiloEstiloAluno;
	}
	 */
	
	public EstiloAlunoEntity buscarByMatriculaSenha(String matricula, String senha) {
		em.clear();
		EstiloAlunoEntity estiloEstiloAluno = (EstiloAlunoEntity) em.createQuery(
					"SELECT a from EstiloEstiloAluno a WHERE a.matricula = :matricula AND a.senha = :senha")
				.setParameter("matricula", matricula)
				.setParameter("senha", senha)
				.getSingleResult();
		
		return estiloEstiloAluno;
	}
	

}
