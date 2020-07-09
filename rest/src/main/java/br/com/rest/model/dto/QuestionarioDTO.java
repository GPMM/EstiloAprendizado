package br.com.rest.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.model.entity.InformacaoPerfilEntity;
import br.com.rest.model.entity.QuestaoEntity;

@XmlRootElement
public class QuestionarioDTO {
	
	private String nome;
	private List<QuestaoEntity> questoes;
	private Map<Integer, String> valorAlternativas = new HashMap<Integer, String>();
	private List<InformacaoPerfilEntity> informacoesPerfis;
	
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
	
	public List<InformacaoPerfilEntity> getInformacoesPerfis() {
		return informacoesPerfis;
	}
	
	public void setInformacoesPerfis(List<InformacaoPerfilEntity> informacoesPerfis) {
		this.informacoesPerfis = informacoesPerfis;
	}

	
	@Override
	public String toString() {
		return "QuestionarioDTO [nome=" + nome + ", questoes=" + questoes + ", valorAlternativas=" + valorAlternativas
				+ ", informacoesPerfis=" + informacoesPerfis + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((informacoesPerfis == null) ? 0 : informacoesPerfis.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
		result = prime * result + ((valorAlternativas == null) ? 0 : valorAlternativas.hashCode());
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
		QuestionarioDTO other = (QuestionarioDTO) obj;
		if (informacoesPerfis == null) {
			if (other.informacoesPerfis != null)
				return false;
		} else if (!informacoesPerfis.equals(other.informacoesPerfis))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (questoes == null) {
			if (other.questoes != null)
				return false;
		} else if (!questoes.equals(other.questoes))
			return false;
		if (valorAlternativas == null) {
			if (other.valorAlternativas != null)
				return false;
		} else if (!valorAlternativas.equals(other.valorAlternativas))
			return false;
		return true;
	}
	
	
	

}
