package br.com.ministeriosemar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ministeriosemar.entities.GrupoGps;

public interface GrupoGpsRepository extends JpaRepository<GrupoGps, UUID> {
	
	/*
	 * Método para consultar 1 Ministério através do nome
	 */
	@Query("SELECT u FROM GrupoGps u WHERE u.nome = :nome")
	GrupoGps find(@Param("nome") String nome);

}
