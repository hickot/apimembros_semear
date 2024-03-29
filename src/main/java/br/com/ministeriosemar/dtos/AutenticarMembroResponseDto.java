package br.com.ministeriosemar.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class AutenticarMembroResponseDto {
	
	private UUID idUsuario;
	private String nome;
	private String email;
	private String accessToken;
	private Instant dataHoraAcesso;
	private Instant dataHoraExpiracao;
}
