package br.com.ministeriosemar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ministeriosemar.entities.Ministerio;

public interface MinisteriosRepository extends JpaRepository<Ministerio, UUID> {
	
	/*
	 * Método para consultar 1 Ministério através do nome
	 */
	@Query("SELECT u FROM Ministerio u WHERE u.nome = :nome")
	Ministerio find(@Param("nome") String nome);
	
	//@Query("SELECT u FROM Ministerio u WHERE u.nome = :nome")
	//Ministerio retornaDados(@Param("id_pk") String id_pk, @Param("lideranca") String lideranca, @Param("nome") String nome);
}
