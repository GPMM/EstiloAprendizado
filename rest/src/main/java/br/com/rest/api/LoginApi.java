package br.com.rest.api;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rest.model.dao.ProfessorDAO;
import br.com.rest.model.dao.QuestionarioDAO;
import br.com.rest.model.dao.RELQuestionarioTurmaDAO;
import br.com.rest.model.dao.TurmaDAO;
import br.com.rest.model.dto.LoginDTO;
import br.com.rest.model.entity.AlunoEntity;
import br.com.rest.model.entity.ProfessorEntity;
import br.com.rest.model.entity.QuestionarioEntity;
import br.com.rest.model.entity.TurmaEntity;
import br.com.rest.services.AlunoServices;

@Path("/login")
public class LoginApi {

	@POST
	@Path("inserir")
	@Produces(MediaType.APPLICATION_JSON)
	public String inserirAluno(AlunoEntity aluno) {
		return AlunoServices.incluirAluno(aluno).toString();
	}

	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public AlunoEntity realizarLoginPorMatriculaSenha(LoginDTO login) {
		return AlunoServices.consultarAlunoPorMatriculaSenha(login.getMatricula(), login.getSenha());
	}

}
