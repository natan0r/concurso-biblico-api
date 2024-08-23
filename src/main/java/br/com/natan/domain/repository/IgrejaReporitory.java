package br.com.natan.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.natan.domain.entity.Igreja;

public interface IgrejaReporitory  extends JpaRepository<Igreja, Integer>{
	
}
