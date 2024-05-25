package br.com.natan.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pessoa")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	@NotEmpty(message = "{campo.data-nascimento.obrigatorio}")
	private LocalDate dataNascimento;
	
	@Column(name = "cpf", length = 11)
	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@Column(name = "saxo")
	@NotEmpty(message = "{campo.sexo.obrigatorio}")
	private String sexo;
}
