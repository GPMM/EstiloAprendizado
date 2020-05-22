package br.com.rest.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class ProfessorEntity extends Usuario{
	
	@Column
	private String siape;
	
	@OneToMany(mappedBy = "professor")
	private List<TurmaEntity> turmas; 
	

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}



}
