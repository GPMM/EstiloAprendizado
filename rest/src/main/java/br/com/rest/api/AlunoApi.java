package br.com.rest.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rest.model.dto.LoginDTO;
import br.com.rest.model.entity.AlunoEntity;
import br.com.rest.services.AlunoServices;

@Path("/aluno")
public class AlunoApi {

	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public String inserirAluno(AlunoEntity aluno) {
		return AlunoServices.incluirAluno(aluno).toString();
	}

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public AlunoEntity realizarLoginPorMatriculaSenha(LoginDTO login) {
		return AlunoServices.consultarAlunoPorMatriculaSenha(login.getMatricula(), login.getSenha());
	}

}
