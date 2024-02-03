package br.com.ministeriosemar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ministeriosemar.dtos.CriarGrupoGpsRequestDto;
import br.com.ministeriosemar.dtos.CriarGrupoGpsResponseDto;
import br.com.ministeriosemar.security.JwtBearerSecurity;
import br.com.ministeriosemar.services.GrupoGpsService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/grupo-gps")
public class GrupoGpsController {
	
	@Autowired
	GrupoGpsService grupoGpsService;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	/*
	 * ENDPOINT POST: /api/usuario/criar
	 */
	
	@PostMapping("criar")
	public CriarGrupoGpsResponseDto criarGrupoGps(@RequestBody @Valid CriarGrupoGpsRequestDto request) {
		
		//executando o serviço de criação de grupo gps e devolvendo o retorno
		return grupoGpsService.criarGrupoGps(request);
	}
	
	

}
