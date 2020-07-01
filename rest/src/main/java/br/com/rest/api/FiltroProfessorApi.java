package br.com.rest.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.rest.model.dto.EstiloAlunoDTO;
import br.com.rest.services.EstiloAlunoServices;

@Path("/resumo-turma")
public class FiltroProfessorApi {

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<EstiloAlunoDTO> consultarResumo(@QueryParam(value = "matricula") String matricula, 
			  					  @QueryParam(value = "startDate") String startDate,
			  					  @QueryParam(value = "endDate") String endDate,
								  @QueryParam(value = "nivel") String nivel, 
								  @QueryParam(value = "turma") String turma) {
		Date dataInicio = null, dataFim = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		if(startDate != null) {
			try {
				dataInicio = format.parse(startDate);
			} catch (ParseException e) {
				System.out.println("Erro ao transformar data inicial");
			}
		}
		
		if(endDate != null) {
			try {
				dataFim = format.parse(endDate);
			} catch (ParseException e) {
				System.out.println("Erro ao transformar data final");
			}
		}
		
		Set<EstiloAlunoDTO> resumoEstilos = EstiloAlunoServices.consultar(matricula, dataInicio, dataFim, nivel, turma);
		return resumoEstilos;
	}
}
