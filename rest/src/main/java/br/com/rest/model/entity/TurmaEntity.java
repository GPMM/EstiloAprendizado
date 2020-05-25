package br.com.rest.model.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Turma")
@Table(name = "TURMA")
@XmlRootElement
public class TurmaEntity {
	
	@Id
	@GeneratedValue
	private Integer idTurma;
	
	@Column(unique=true)
	private String codigo;
	
	@ManyToMany
	@JoinTable(name = "REL_TURMA_QUESTIONARIO",
    joinColumns = @JoinColumn(name = "fk_turma"), inverseJoinColumns = @JoinColumn(name = "fk_questionario"))
	private Set<QuestionarioEntity> questionarios;
	
	@ManyToOne
	@JoinColumn(name = "fk_professor")
	private ProfessorEntity professor;
	
	@Column
	private String disciplina;
	
	@ManyToMany
	@JoinTable(name = "REL_TURMA_ALUNO",
		joinColumns = { @JoinColumn(name = "fk_turma") },
		inverseJoinColumns = { @JoinColumn(name = "fk_aluno") })
	private List<AlunoEntity> alunos;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurmaEntity other = (TurmaEntity) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TurmaEntity [idTurma=" + idTurma + ", codigo=" + codigo + ", professor=" + professor + "]";
	}


}
