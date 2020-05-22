package br.com.rest.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class AlunoEntity extends Usuario{
	
	
	@Column
	private String matricula;

	@Column
	private String turma;

	@Column
	private Integer perfilAtivo;
	
	@Column
	private Integer perfilReflexivo;
	
	@Column
	private Integer perfilPragmatico;
	
	@Column
	private Integer perfilTeorico;
	


	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	public String getTurma() {
		return turma;
	}
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getPerfilAtivo() {
		return perfilAtivo;
	}
	
	public void setPerfilAtivo(Integer perfilAtivo) {
		this.perfilAtivo = perfilAtivo;
	}
	
	public Integer getPerfilReflexivo() {
		return perfilReflexivo;
	}
	
	public void setPerfilReflexivo(Integer perfilReflexivo) {
		this.perfilReflexivo = perfilReflexivo;
	}
	
	public Integer getPerfilPragmatico() {
		return perfilPragmatico;
	}
	
	public void setPerfilPragmatico(Integer perfilPragmatico) {
		this.perfilPragmatico = perfilPragmatico;
	}
	
	public Integer getPerfilTeorico() {
		return perfilTeorico;
	}
	
	public void setPerfilTeorico(Integer perfilTeorico) {
		this.perfilTeorico = perfilTeorico;
	}


}
