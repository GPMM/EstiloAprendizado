package br.com.rest.model.dao;

import br.com.rest.model.entity.TurmaEntity;

public class TurmaDAO extends GenericDAO<TurmaEntity>{
	
	private static TurmaDAO instance = null;
	
	private TurmaDAO() {
		super(TurmaEntity.class, PersistenceManager.getEntityManager());
	}
	
	public synchronized static TurmaDAO getInstance() {
		if(instance == null) {
			instance = new TurmaDAO();
		}
		return instance;
	}
	
	public TurmaEntity buscarByCodigo(String codigo) {
		em.clear();
		TurmaEntity turma = (TurmaEntity) em.createQuery(
					"Select a from TurmaEntity a Where a.codigo LIKE :codigo")
				.setParameter("matricula", codigo)
				.getSingleResult();
		
		return turma;
				
	}
	
	public TurmaEntity buscarByIdProfessor(Integer idProfessor) {
		em.clear();
		TurmaEntity turma = (TurmaEntity) em.createQuery(
					"SELECT a from TurmaEntity a WHERE a.professor = :idProfessor")
				.setParameter("idProfessor", idProfessor)
				.getSingleResult();
		
		return turma;
	}

}
