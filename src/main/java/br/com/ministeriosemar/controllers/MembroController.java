package br.com.ministeriosemar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ministeriosemar.dtos.AutenticarMembroRequestDto;
import br.com.ministeriosemar.dtos.AutenticarMembroResponseDto;
import br.com.ministeriosemar.dtos.CriarMembroRequestDto;
import br.com.ministeriosemar.dtos.CriarMembroResponseDto;
import br.com.ministeriosemar.security.JwtBearerSecurity;
import br.com.ministeriosemar.services.MembroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/membro")
public class MembroController {
	
	@Autowired
	MembroService membroService;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	/*
	 * ENDPOINT POST: /api/usuario/criar
	 */
	
	@PostMapping("criar")
	public CriarMembroResponseDto criarUsuario(@RequestBody @Valid CriarMembroRequestDto request) {
		
		//executando o serviço de criação de usuário e devolvendo o retorno
		return membroService.criarUsuario(request);
	}
	
	/*
	 * ENDPOINT POST: /api/usuario/autenticar
	 */
	@PostMapping("autenticar")
	public AutenticarMembroResponseDto autenticarUsuario(@RequestBody @Valid AutenticarMembroRequestDto request) throws IllegalAccessException {
		
		//executando o serviço de autenticação de usuário e devolvendo o retorno
		return membroService.autenticarUsuario(request);
	}
}