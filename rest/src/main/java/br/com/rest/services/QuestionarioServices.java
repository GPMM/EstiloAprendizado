package br.com.rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.rest.model.dao.AlunoDAO;
import br.com.rest.model.dao.GrupoAlunoDAO;
import br.com.rest.model.dao.PersistenceManager;
import br.com.rest.model.dao.QuestionarioDAO;
import br.com.rest.model.dto.QuestionarioDTO;
import br.com.rest.model.entity.AlunoEntity;
import br.com.rest.model.entity.InformacaoPerfilEntity;
import br.com.rest.model.entity.QuestaoEntity;
import br.com.rest.model.entity.QuestionarioEntity;

public class QuestionarioServices {
	
	private static QuestionarioDAO questionarioDao = QuestionarioDAO.getInstance();
	private static GrupoAlunoDAO grupoAlunoDao = GrupoAlunoDAO.getInstance();
	private static AlunoDAO alunoDao = AlunoDAO.getInstance();
	
	
	public static Boolean incluirQuestionario(QuestionarioDTO questionario) {
		QuestionarioEntity questionarioBanco = null;
		
		try {
			 questionarioBanco = questionarioDao.findByNome(questionario.getNome());
		} catch (NoResultException e) {
			System.out.println("Questionario não encontrado no banco, pode ser incluido");
		
		}
		
		if(questionarioBanco != null) {
			return false;
		} else {
			PersistenceManager.getTransaction().begin();
			
			try{
				QuestionarioEntity quest = new QuestionarioEntity();
				questionarioDtoToEntity(questionario, quest);
				questionarioDao.incluir(quest);	
				PersistenceManager.getTransaction().commit();
				return true;
			}catch(Exception e){
				e.printStackTrace();
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
	
	public static QuestionarioEntity questionarioDtoToEntity(QuestionarioDTO quest, QuestionarioEntity questEntity) {
		if(quest.getInformacoesPerfis() != null && quest.getInformacoesPerfis().size() > 0) {
			for(InformacaoPerfilEntity info: quest.getInformacoesPerfis()) {
				InformacaoPerfilEntity infoEntity = new InformacaoPerfilEntity();
				infoEntity.setCaracteristicas(info.getCaracteristicas());
				infoEntity.setSugestoes(info.getSugestoes());
				infoEntity.setTipoPerfil(info.getTipoPerfil());
				questEntity.addInformacoesPerfis(infoEntity);
			}
		}		
		if(quest.getQuestoes() != null && quest.getQuestoes().size() > 0) {
			for(QuestaoEntity questao: quest.getQuestoes()) {
				QuestaoEntity questaoEntity = new QuestaoEntity();
				questaoEntity.setTexto(questao.getTexto());
				questaoEntity.setTipoPerfil(questao.getTipoPerfil());
				questEntity.addQuestao(questaoEntity);
			}
		}
		if(quest.getValorAlternativas() != null && quest.getValorAlternativas().size() > 0) {
			for(Integer key: quest.getValorAlternativas().keySet()) {
				questEntity.addValorAlternativas(key, quest.getValorAlternativas().get(key));				
			}
		}
		questEntity.setNome(quest.getNome());
		
		return questEntity;		
	}
}
