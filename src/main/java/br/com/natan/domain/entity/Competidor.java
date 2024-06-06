package br.com.natan.domain.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.natan.domain.enums.ManualEnum;
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
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "igreja_id")
	private Igreja igreja;
	
	@ManyToOne
	@JoinColumn(name = "concurso_id")
	private Concurso concurso;
	
	@Convert(converter = ManualEnum.class)
	@Column(name = "manual_id")
	private ManualEnum manualId;
}