package br.com.natan.domain.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "competidor")
public class Competidor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Integer pessoaId;
	
	@OneToMany(mappedBy = "igreja_id", fetch = FetchType.LAZY)
	private Integer igrejaId;
	
	@OneToMany(mappedBy = "concurso_id", fetch = FetchType.LAZY)
	private Integer concursoId;
}
