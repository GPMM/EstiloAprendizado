package br.com.rest.model.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.model.entity.InformacaoPerfilEntity;

@XmlRootElement
public class EstiloAlunoDTO {

	private Long idPerfil;
	private String matriculaAluno;
	private String nomeAluno;
	private Long idAluno;
	private Integer perfilAtivo;
	private Integer perfilReflexivo;
	private Integer perfilPragmatico;
	private Integer perfilTeorico;
	private Date dataRealizado;
	private String nomeQuestionario;
	private Long idQuestionario;
	private List<InformacaoPerfilEntity> infoPerfis;

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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

	public Date getDataRealizado() {
		return dataRealizado;
	}

	public void setDataRealizado(Date dataRealizado) {
		this.dataRealizado = dataRealizado;
	}

	public String getNomeQuestionario() {
		return nomeQuestionario;
	}

	public void setNomeQuestionario(String nomeQuestionario) {
		this.nomeQuestionario = nomeQuestionario;
	}

	public Long getIdQuestionario() {
		return idQuestionario;
	}

	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	
	public List<InformacaoPerfilEntity> getInfoPerfis() {
		return infoPerfis;
	}

	public void setInfoPerfis(List<InformacaoPerfilEntity> infoPerfis) {
		this.infoPerfis = infoPerfis;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPerfil == null) ? 0 : idPerfil.hashCode());
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
		EstiloAlunoDTO other = (EstiloAlunoDTO) obj;
		if (idPerfil == null) {
			if (other.idPerfil != null)
				return false;
		} else if (!idPerfil.equals(other.idPerfil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstiloAlunoDTO [idPerfil=" + idPerfil + ", matriculaAluno=" + matriculaAluno + ", nomeAluno="
				+ nomeAluno + ", idAluno=" + idAluno + ", perfilAtivo=" + perfilAtivo + ", perfilReflexivo="
				+ perfilReflexivo + ", perfilPragmatico=" + perfilPragmatico + ", perfilTeorico=" + perfilTeorico
				+ ", dataRealizado=" + dataRealizado + ", nomeQuestionario=" + nomeQuestionario + ", idQuestionario="
				+ idQuestionario + ", infoPerfis=" + infoPerfis + "]";
	}
}
