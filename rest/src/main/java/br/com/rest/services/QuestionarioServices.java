package br.com.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.rest.model.dao.AlunoDAO;
import br.com.rest.model.dao.GrupoAlunoDAO;
import br.com.rest.model.dao.PersistenceManager;
import br.com.rest.model.dao.QuestionarioDAO;
import br.com.rest.model.entity.AlunoEntity;
import br.com.rest.model.entity.QuestionarioEntity;

public class QuestionarioServices {
	
	private static QuestionarioDAO questionarioDao = QuestionarioDAO.getInstance();
	private static GrupoAlunoDAO grupoAlunoDao = GrupoAlunoDAO.getInstance();
	private static AlunoDAO alunoDao = AlunoDAO.getInstance();
	
	
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
	
	public static List<QuestionarioEntity> buscarQuestionariosPorGruposAluno(String matricula){
		List<QuestionarioEntity> questionariosBanco = new ArrayList<QuestionarioEntity>();
		AlunoEntity aluno = null;
		try {
			aluno = alunoDao.buscarByMatricula(matricula);
		} catch(NoResultException e) {
			throw new WebApplicationException(
				      Response.status(Response.Status.NO_CONTENT)
				        .entity("Aluno não existe no banco")
				        .build()
				    );
		}
		
		try {
			questionariosBanco = grupoAlunoDao.findQuestionariosByGruposAluno(aluno);
		} catch(NoResultException e) {
			throw new WebApplicationException(
				      Response.status(Response.Status.NO_CONTENT)
				        .entity("Aluno não está em nenhum grupo de alunos com questionários disponíveis")
				        .build()
				    );
		}
		return questionariosBanco;
	}
}
