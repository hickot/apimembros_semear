package br.com.ministeriosemar.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarMinisterioRequestDto {
	
	@Size(min = 3, max = 150, message = "Por favor, informe de 3 à 150 caracteres.")
	@NotBlank(message = "Por favor, informe o nome da liderança")
	private String lideranca;
	
	@Size(min = 3, max = 150, message = "Por favor, informe de 3 à 150 caracteres.")
	@NotBlank(message = "Por favor, informe o nome para o Ministério")
	private String nome;
}
