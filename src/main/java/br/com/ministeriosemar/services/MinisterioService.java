package br.com.ministeriosemar.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ministeriosemar.dtos.CriarMinisterioRequestDto;
import br.com.ministeriosemar.dtos.CriarMinisterioResponseDto;
import br.com.ministeriosemar.entities.Ministerio;
import br.com.ministeriosemar.repositories.MinisteriosRepository;
import br.com.ministeriosemar.security.JwtBearerSecurity;

@Service
public class MinisterioService {
	
	@Autowired
	MinisteriosRepository ministeriosRepository;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	/*
	 * Método para criar um ministério
	 */
	public CriarMinisterioResponseDto criarMinisterio(CriarMinisterioRequestDto request) {


		//verificar se já existe um usuário cadastrado com o email informado
		if(ministeriosRepository.find(request.getNome()) != null) {
			throw new IllegalArgumentException("Já existe um ministério cadastrado com o nome informado.");
		}
		
		//capturar os dados do usuário
		Ministerio ministerio = new Ministerio();
		
		ministerio.setIdMinisterio(UUID.randomUUID());
		ministerio.setLideranca(request.getLideranca());
		ministerio.setNome(request.getNome());
		
		//gravar o ministério no banco de dados
		ministeriosRepository.save(ministerio);
		
		//retornar os dados
		CriarMinisterioResponseDto response = new CriarMinisterioResponseDto();
		
		response.setIdMinisterio(ministerio.getIdMinisterio());
		response.setLideranca(ministerio.getLideranca());
		response.setNome(ministerio.getNome());
		
		return response;
	}
}
