package br.com.natan.rest;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ApiErrors{
	
	@Getter
	@Setter
	private List<String> errors;

	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String mensagemErro) {
		this.errors = Arrays.asList(mensagemErro);
		
	}
}