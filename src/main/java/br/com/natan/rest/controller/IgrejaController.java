package br.com.natan.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.natan.domain.entity.Igreja;
import br.com.natan.domain.repository.IgrejaReporitory;

@RestController
@RequestMapping("/api/igrejas")
public class IgrejaController {

	@Autowired
	private IgrejaReporitory igrejaReporitory;

	public IgrejaController(IgrejaReporitory igrejaReporitory) {
		this.igrejaReporitory = igrejaReporitory;
	}
	
	@GetMapping("{id}")
	public Igreja getIgrejaById(@PathVariable Integer id) {
		return igrejaReporitory
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Igreja não encontrada."));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Igreja saveIgreja(@RequestBody 
								@Valid Igreja igreja) {
		return igrejaReporitory.save(igreja);
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteIgreja(@PathVariable Integer id) {
		igrejaReporitory
						.findById(id)
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Igreja não encontrada."));
		
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateIgreja(@PathVariable Integer id,
								@RequestBody @Valid Igreja igreja) {
		igrejaReporitory
						.findById(id)
						.map(igrejaExistente -> {
							igreja.setId(igrejaExistente.getId());
							igrejaReporitory.save(igreja);
							return igrejaExistente;
						}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Igreja não encontrada."));
	}
	
	public List<Igreja> findIgreja (Igreja filtro){
		ExampleMatcher matcher = ExampleMatcher
									.matching()
									.withIgnoreCase()
									.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example example = Example.of(filtro, matcher);
		return igrejaReporitory.findAll(example);
	}
}
