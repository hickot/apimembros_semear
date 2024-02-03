package br.com.ministeriosemar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ministeriosemar.entities.Membro;

public interface MembrosRepository  extends JpaRepository<Membro, UUID>{
	
	/*
	 * Método para consultar 1 usuário através do email
	 */
	@Query("SELECT u FROM Membro u WHERE u.email = :email")
	Membro find(@Param("email") String email);
	
	/*
	 * Método para consultar 1 usuário através do email e da senha
	 */
	@Query("SELECT u FROM Membro u WHERE u.email = :email AND u.senha = :senha")
	Membro find(@Param("email") String email, @Param("senha") String senha);
	
	
	
}
