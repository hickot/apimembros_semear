package br.com.ministeriosemar.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class CriarGrupoGpsResponseDto {
	
	private UUID idGrupoGps;
	private String lideranca;
	private String nome;
}
