package br.com.rest.model.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class QuestionarioEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ElementCollection
	private List<String> questoes;
	
	@ElementCollection
	private Map<Integer, String> valorAlternativas;

}
