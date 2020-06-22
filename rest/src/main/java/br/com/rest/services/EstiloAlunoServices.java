package br.com.rest.services;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.rest.model.dao.EstiloAlunoDAO;
import br.com.rest.model.entity.EstiloAlunoEntity;

public class EstiloAlunoServices {
	
	private static EstiloAlunoDAO estiloAlunoDao = EstiloAlunoDAO.getInstance();
	
	
	public static List<EstiloAlunoEntity> consultar(String matricula, Date startDate, Date endDate, String nivel, String turma) {
		List<EstiloAlunoEntity> resumoEstiloAlunos = null;
		try {
			resumoEstiloAlunos = estiloAlunoDao.dynamicQueryFiltro(matricula, startDate, endDate, nivel, turma);
			return resumoEstiloAlunos;
		} catch(NoResultException e) {
			return resumoEstiloAlunos;
		}
	}
}
