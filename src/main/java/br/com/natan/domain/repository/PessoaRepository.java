package br.com.natan.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.natan.domain.entity.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	@Query(value = " select * from pessoa p where p.nome like %:nome ", nativeQuery = true)
	List<Pessoa> findByName(@Param("nome") String nome);
	
	@Query(" delete from Pessoa p where p.nome =:nome ")
	@Modifying
	void deleteByName(String nome);
	
	@Query(" select p from Pessoa p left join fetch p.igreja where p.id = :id ")
	Pessoa findPessoaFetchIgreja( @Param("id") Integer id);
}
