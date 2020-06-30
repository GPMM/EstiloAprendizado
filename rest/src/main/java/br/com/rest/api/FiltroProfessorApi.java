package br.com.rest.api;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.rest.model.dto.LoginDTO;
import br.com.rest.model.entity.AlunoEntity;
import br.com.rest.model.entity.EstiloAlunoEntity;
import br.com.rest.services.AlunoServices;
import br.com.rest.services.EstiloAlunoServices;

@Path("/resumo-turma")
public class FiltroProfessorApi {

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstiloAlunoEntity> consultarResumo(@QueryParam(value = "matricula") String matricula, 
			  					  @QueryParam(value = "startDate") String startDate,
			  					  @QueryParam(value = "endDate") String endDate,
								  @QueryParam(value = "nivel") String nivel, 
								  @QueryParam(value = "turma") String turma) {
		List<EstiloAlunoEntity> resumoEstilos = EstiloAlunoServices.consultar(matricula,null, null, nivel, turma);
		return resumoEstilos;
	}
}
