package br.com.natan.domain.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Concurso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "igreja_id")
	@OneToMany(mappedBy = "igreja" , fetch = FetchType.LAZY)
	private Integer igreja;
}