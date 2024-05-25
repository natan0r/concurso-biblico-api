package br.com.natan.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "igreja")
public class Igreja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_igreja")
	private Integer id;
	
	@Column(name = "nome_igreja")
	@NotEmpty(message = "{campo.igreja.obrigatorio}")
	private String nomeIgreja;
}
