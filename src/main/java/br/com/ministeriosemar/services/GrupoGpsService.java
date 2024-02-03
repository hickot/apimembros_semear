package br.com.ministeriosemar.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ministeriosemar.dtos.CriarGrupoGpsRequestDto;
import br.com.ministeriosemar.dtos.CriarGrupoGpsResponseDto;
import br.com.ministeriosemar.entities.GrupoGps;
import br.com.ministeriosemar.repositories.GrupoGpsRepository;
import br.com.ministeriosemar.security.JwtBearerSecurity;

@Service
public class GrupoGpsService {
	
	@Autowired
	GrupoGpsRepository grupoGpsRepository;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	/*
	 * Método para criar um ministério
	 */
	public CriarGrupoGpsResponseDto criarGrupoGps(CriarGrupoGpsRequestDto request) {


		//verificar se já existe um usuário cadastrado com o email informado
		if(grupoGpsRepository.find(request.getNome()) != null) {
			throw new IllegalArgumentException("Já existe um grupo de gps cadastrado com o nome informado.");
		}
		
		//capturar os dados do usuário
		GrupoGps grupoGps = new GrupoGps();
		
		grupoGps.setIdGrupoGps(UUID.randomUUID());
		grupoGps.setLideranca(request.getLideranca());
		
		if(request.getNome() != null && !"".equals(grupoGps.getNome())) {
			
			grupoGps.setNome(request.getNome());
		} else {
			
			grupoGps.setNome(null);
		}
		
		//gravar o ministério no banco de dados
		grupoGpsRepository.save(grupoGps);
		
		//retornar os dados
		CriarGrupoGpsResponseDto response = new CriarGrupoGpsResponseDto();
		
		response.setIdGrupoGps(grupoGps.getIdGrupoGps());
		response.setLideranca(grupoGps.getLideranca());
		
		if (grupoGps.getNome() != null && !"".equals(grupoGps.getNome())) {
			
			response.setNome(grupoGps.getNome());
		} else {
			
			response.setNome(null);
		}
		
		return response;
	}

}
