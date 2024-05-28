package br.com.natan.domain.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.natan.domain.enums.ManualEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pontuacao")
public class Pontuacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "competidor_id")
	private Integer competidorId;
	
	@OneToOne
    @JoinColumn(name = "pontos")
	private Integer pontos;
	
	@Convert(converter = ManualEnum.class)
	private ManualEnum manualId;
}
