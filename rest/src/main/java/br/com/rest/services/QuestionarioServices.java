package br.com.rest.services;

import javax.persistence.NoResultException;

import br.com.rest.model.dao.PersistenceManager;
import br.com.rest.model.dao.QuestionarioDAO;
import br.com.rest.model.dto.EstiloAlunoDTO;
import br.com.rest.model.entity.EstiloAlunoEntity;
import br.com.rest.model.entity.QuestionarioEntity;

public class QuestionarioServices {
	
	private static QuestionarioDAO questionarioDao = QuestionarioDAO.getInstance();
	
	
	public static Boolean incluirQuestionario(QuestionarioEntity questionario) {
		QuestionarioEntity questionarioBanco = null;
		try {
			 questionarioBanco = questionarioDao.find(questionario.getIdQuestionario());
		} catch (NoResultException e) {
			System.out.println("Questionario não encontrado no banco, pode ser incluido");
		
		}
		
		if(questionarioBanco != null) {
			return false;
		} else {
			PersistenceManager.getTransaction().begin();
			
			try{
				questionarioDao.incluir(questionario);	
				PersistenceManager.getTransaction().commit();
				return true;
			}catch(Exception e){
				PersistenceManager.getTransaction().rollback();
				return false;
			}
		}
	}
}
