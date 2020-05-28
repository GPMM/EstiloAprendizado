package br.com.rest.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.model.enumentity.TiposPerfilEnum;

@Entity(name = "Questao")
@Table(name = "QUESTAO")
@XmlRootElement
public class QuestaoEntity {
	
	@Id
	@GeneratedValue
	private Integer idQuestao;
	
	@Column
	private String texto;
	
	@Enumerated(EnumType.STRING)
	private TiposPerfilEnum tipoPerfil;
	
	@ManyToOne
	@JoinColumn(name = "fk_questionario", nullable = false)
	private QuestionarioEntity questionario;
	
	public QuestaoEntity() {
		
	}
	
	public QuestaoEntity(String texto, TiposPerfilEnum tipoPerfil, QuestionarioEntity questionario) {
		this.texto = texto;
		this.tipoPerfil = tipoPerfil;
		this.questionario = questionario;
	}

	public Integer getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public TiposPerfilEnum getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(TiposPerfilEnum tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public QuestionarioEntity getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioEntity questionario) {
		this.questionario = questionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuestao == null) ? 0 : idQuestao.hashCode());
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
		QuestaoEntity other = (QuestaoEntity) obj;
		if (idQuestao == null) {
			if (other.idQuestao != null)
				return false;
		} else if (!idQuestao.equals(other.idQuestao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestaoEntity [idQuestao=" + idQuestao + ", texto=" + texto + ", tipoPerfil=" + tipoPerfil + "]";
	}
	
	

}
