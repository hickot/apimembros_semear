package br.com.ministeriosemar.dtos;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarMembroRequestDto {
	
	@Size(min = 8, max = 150, message = "Por favor, informe de 8 à 150 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotBlank(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
			message = "Por favor, informe uma senha com letras maiúsculas, letras minúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotBlank(message = "Por favor, informe a senha do usuário.")
	private String senha;
	
	private String endereco;
	private Date dataNascimento;
	private String cargo;
	private Date dataBatismo;
	private String nomeMinisterio; //rever essa lista
	private Date membroDesde;
	private String sexo;
	private String estadoCivil;
	private Date dataCasamento;
	private String celular;
	private String telefone;
	private boolean batizado;
	private String naturalidade;
	private String profissao;
	private String escolaridade;
	private String nomeGps; //rever essa lista
	
}
