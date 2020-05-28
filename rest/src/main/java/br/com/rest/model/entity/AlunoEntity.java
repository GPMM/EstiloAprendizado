package br.com.rest.model.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Aluno")
@Table(name = "ALUNO")
@XmlRootElement
public class AlunoEntity extends Usuario{
	
	
	@Column(unique=true)
	private String matricula;

	@ManyToMany(mappedBy="alunos")
	private Set<TurmaEntity> turmas;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<AlunoQuestionarioPerfilEntity> questionariosPerfil;

	public void setTurmas(Set<TurmaEntity> turmas) {
		this.turmas = turmas;
	}
	
	public Set<TurmaEntity> getTurmas() {
		return turmas;
	}
	
	public void addTurma(TurmaEntity turma) {
		if(turma != null) {
			this.turmas.add(turma);
		}
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<AlunoQuestionarioPerfilEntity> getQuestionariosPerfil() {
		return questionariosPerfil;
	}

	public void setQuestionariosPerfil(List<AlunoQuestionarioPerfilEntity> questionariosPerfil) {
		this.questionariosPerfil = questionariosPerfil;
	}

	@Override
	public String toString() {
		return "AlunoEntity [matricula=" + matricula + ", turmas=" + turmas + ", id=" + getId() + ", cpf=" + getCpf() + ", nome=" + getNome()
				+ ", email=" + getEmail() + ", idade=" + getIdade() + ", genero=" + getGenero()+"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorEntity other = (ProfessorEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}


}
