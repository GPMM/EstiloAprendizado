package br.com.rest.model.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Questionario")
@Table(name = "QUESTIONARIO")
@XmlRootElement
public class QuestionarioEntity  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idQuestionario;
	
	@Column
	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_questao")
	private List<QuestaoEntity> questoes;

	@JoinTable(name="COL_VALOR_ALTERNATIVAS", joinColumns=@JoinColumn(name="idQuestionario"))
	@MapKeyColumn (name="numeroAlternativa")
	@Column(name="valorAlternativas")
	@ElementCollection
	private Map<Integer, String> valorAlternativas = new HashMap<Integer, String>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<QuestaoEntity> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<QuestaoEntity> questoes) {
		this.questoes = questoes;
	}

	public Map<Integer, String> getValorAlternativas() {
		return valorAlternativas;
	}

	public void setValorAlternativas(Map<Integer, String> valorAlternativas) {
		this.valorAlternativas = valorAlternativas;
	}

	public void setIdQuestionario(Integer idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	
	public Integer getIdQuestionario() {
		return idQuestionario;
	}

	@Override
	public String toString() {
		return "QuestionarioEntity [idQuestionario=" + idQuestionario + ", nome=" + nome + ", questoes=" + questoes + ", valorAlternativas=" + valorAlternativas
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuestionario == null) ? 0 : idQuestionario.hashCode());
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
		if (idQuestionario == null) {
			if (other.idQuestionario != null)
				return false;
		} else if (!idQuestionario.equals(other.idQuestionario))
			return false;
		return true;
	}
	
	

}
