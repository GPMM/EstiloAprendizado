package br.com.rest.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class TurmaEntity {
	
	@Id
	@GeneratedValue
	private Integer idTurma;
	
	@Column
	private String codigo;
	
	@ManyToMany
	@JoinTable(name = "idQuestionario",
    joinColumns = @JoinColumn(name = "idTurma"), inverseJoinColumns = @JoinColumn(name = "idQuestionario"))
	private List<QuestionarioEntity> questionarios;
	
	@ManyToOne
	@JoinColumn(name = "idProfessor")
	private ProfessorEntity professor;

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
