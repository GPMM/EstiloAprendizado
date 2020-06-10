package br.com.rest.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.model.enumentity.TiposPerfilEnum;

@Entity(name = "InformacaoPerfil")
@Table(name = "INFOPERFIL")
@XmlRootElement
public class InformacaoPerfilEntity implements Serializable{

	private static final long serialVersionUID = -3951992385753090027L;
	
	@Id
	@GeneratedValue
	private Long idInfo;
	
	@Column
	private String caracteristicas;
	
	@Column
	private String sugestoes;
	
	@Enumerated(EnumType.STRING)
	private TiposPerfilEnum tipoPerfil;
	
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getSugestoes() {
		return sugestoes;
	}

	public void setSugestoes(String sugestoes) {
		this.sugestoes = sugestoes;
	}

	public TiposPerfilEnum getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(TiposPerfilEnum tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

}
