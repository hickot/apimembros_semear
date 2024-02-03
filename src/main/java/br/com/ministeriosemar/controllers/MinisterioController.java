package br.com.ministeriosemar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ministeriosemar.dtos.CriarMinisterioRequestDto;
import br.com.ministeriosemar.dtos.CriarMinisterioResponseDto;
import br.com.ministeriosemar.security.JwtBearerSecurity;
import br.com.ministeriosemar.services.MinisterioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/ministerio")
public class MinisterioController {
	
	@Autowired
	MinisterioService ministerioService;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	/*
	 * ENDPOINT POST: /api/ministerio/criar
	 */
	
	@PostMapping("criar")
	public CriarMinisterioResponseDto criarMinisterio(@RequestBody @Valid CriarMinisterioRequestDto request) {
		
		//executando o serviço de criação de ministério e devolvendo o retorno
		return ministerioService.criarMinisterio(request);
	}

}
