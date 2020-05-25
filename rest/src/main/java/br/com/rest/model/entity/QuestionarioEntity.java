package br.com.rest.model.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Questionario")
@Table(name = "QUESTIONARIO")
@XmlRootElement
public class QuestionarioEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String nome;
	
	@ManyToMany(mappedBy="questionarios")
	private Set<TurmaEntity> turmas;
	
	@ElementCollection
	private List<String> questoes;
	
	@ElementCollection
	private Map<Integer, String> valorAlternativas;

	@Override
	public String toString() {
		return "QuestionarioEntity [id=" + id + ", nome=" + nome + ", questoes=" + questoes + ", valorAlternativas=" + valorAlternativas
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		QuestionarioEntity other = (QuestionarioEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
