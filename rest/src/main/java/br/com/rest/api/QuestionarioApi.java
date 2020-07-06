package br.com.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.istack.NotNull;

import br.com.rest.model.dto.EstiloAlunoDTO;
import br.com.rest.services.EstiloAlunoServices;

@Path("/questionario")
public class QuestionarioApi {
/*
	@GET
	@Path("dados-aluno")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public EstiloAlunoDTO consultarDadosAlunoQuestionario(@NotNull @QueryParam(value = "matricula") String matricula, @NotNull @QueryParam(value = "idQuest") Long idQuestionario) {
		EstiloAlunoDTO retorno = null;
		List<EstiloAlunoDTO> consultar = (List<EstiloAlunoDTO>) EstiloAlunoServices.consultar(idQuestionario, matricula, null, null, null, null);
		List<EstiloAlunoDTO> listaConsulta = consultar;
		if(listaConsulta != null && listaConsulta.size() == 1)
			retorno = listaConsulta.get(0);
		
		return retorno;
	}*/

}
