package br.com.rest.model.dao;

import br.com.rest.model.entity.ProfessorEntity;

public class ProfessorDAO extends GenericDAO<ProfessorEntity>{
	
	private static ProfessorDAO instance = null;
	
	private ProfessorDAO() {
		super(ProfessorEntity.class, PersistenceManager.getEntityManager());
	}
	
	public synchronized static ProfessorDAO getInstance() {
		if(instance == null) {
			instance = new ProfessorDAO();
		}
		return instance;
	}
	
	public ProfessorEntity buscarBySiape(String siape) {
		em.clear();
		ProfessorEntity professor = (ProfessorEntity) em.createQuery(
					"Select a from ProfessorEntity a Where a.siape LIKE :siape")
				.setParameter("siape", siape)
				.getSingleResult();
		
		return professor;
				
	}

}
