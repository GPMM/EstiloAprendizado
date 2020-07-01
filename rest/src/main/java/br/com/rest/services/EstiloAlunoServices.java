package br.com.rest.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.NoResultException;

import br.com.rest.model.dao.EstiloAlunoDAO;
import br.com.rest.model.dto.EstiloAlunoDTO;
import br.com.rest.model.entity.EstiloAlunoEntity;

public class EstiloAlunoServices {
	
	private static EstiloAlunoDAO estiloAlunoDao = EstiloAlunoDAO.getInstance();
	
	
	public static Set<EstiloAlunoDTO> consultar(String matricula, Date startDate, Date endDate, String nivel, String turma) {
		Set<EstiloAlunoEntity> resumoEstiloAlunos = null;
		Set<EstiloAlunoDTO> resumoEstiloAlunosDTO = null;
		try {
			resumoEstiloAlunos = estiloAlunoDao.dynamicQueryFiltro(matricula, startDate, endDate, nivel, turma);
			resumoEstiloAlunosDTO = new HashSet<EstiloAlunoDTO>();
			for(EstiloAlunoEntity estiloAluno : resumoEstiloAlunos) {
				EstiloAlunoDTO estiloDto = new EstiloAlunoDTO();
				
				if(estiloAluno.getAluno() != null) {
					estiloDto.setIdAluno(estiloAluno.getAluno().getId());
					estiloDto.setMatriculaAluno(estiloAluno.getAluno().getMatricula());
					estiloDto.setNomeAluno(estiloAluno.getAluno().getNome());
				}
				
				estiloDto.setDataRealizado(estiloAluno.getDataRealizado());
				estiloDto.setIdPerfil(estiloAluno.getIdPerfil());
				estiloDto.setIdQuestionario(estiloAluno.getQuestionario().getIdQuestionario());
				estiloDto.setNomeQuestionario(estiloAluno.getQuestionario().getNome());
				estiloDto.setPerfilAtivo(estiloAluno.getPerfilAtivo());
				estiloDto.setPerfilTeorico(estiloAluno.getPerfilTeorico());
				estiloDto.setPerfilReflexivo(estiloAluno.getPerfilReflexivo());
				estiloDto.setPerfilPragmatico(estiloAluno.getPerfilPragmatico());
				
				resumoEstiloAlunosDTO.add(estiloDto);
			}
			
			return resumoEstiloAlunosDTO;
		} catch(NoResultException e) {
			e.printStackTrace();
			return resumoEstiloAlunosDTO;
		}
	}
}
