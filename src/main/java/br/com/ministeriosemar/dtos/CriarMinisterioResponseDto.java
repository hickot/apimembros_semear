package br.com.ministeriosemar.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class CriarMinisterioResponseDto {
	
	private UUID idMinisterio;
	private String lideranca;
	private String nome;

}
