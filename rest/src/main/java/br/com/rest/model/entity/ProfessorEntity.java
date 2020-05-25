package br.com.rest.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Professor")
@Table(name = "PROFESSOR")
public class ProfessorEntity extends Usuario{
	
	@Column
	private String siape;
	
	@OneToMany(mappedBy = "professor")
	private Set<TurmaEntity> turmas; 
	

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
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

	@Override
	public String toString() {
		return "ProfessorEntity [siape=" + siape + ", turmas=" + turmas + ", id=" + getId() + ", cpf=" + getCpf() + ", nome=" + getNome()
		+ ", email=" + getEmail() + ", idade=" + getIdade() + ", genero=" + getGenero()+"]";
	}

}
