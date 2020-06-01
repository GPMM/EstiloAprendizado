package br.com.rest.model.dao;

import java.util.List;

import br.com.rest.model.entity.QuestionarioEntity;

public class QuestionarioDAO extends GenericDAO<QuestionarioEntity>{
	
	private static QuestionarioDAO instance = null;
	
	private QuestionarioDAO() {
		super(QuestionarioEntity.class, PersistenceManager.getEntityManager());
	}
	
	public synchronized static QuestionarioDAO getInstance() {
		if(instance == null) {
			instance = new QuestionarioDAO();
		}
		return instance;
	}
	
	public List<QuestionarioEntity> buscarByTurma(String turmaCodigo) {
		em.clear();
		List<QuestionarioEntity> questionarios = (List<QuestionarioEntity>) em.createQuery(
					"select q " + 
					"from Questionario q " + 
					"join q.turmas t " + 
					"where t.codigo = :turmaCodigo ")
				.setParameter("turmaCodigo", turmaCodigo)
				.getResultList();
		
		return questionarios;
				
	}

}
