package br.com.ministeriosemar.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AutenticarMembroRequestDto {
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotBlank(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
			message = "Por favor, informe uma senha com letras maiúsculas, letras minúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotBlank(message = "Por favor, informe a senha do usuário.")
	private String senha;

}
