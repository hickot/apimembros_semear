package br.com.ministeriosemar.services;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ministeriosemar.dtos.AutenticarMembroRequestDto;
import br.com.ministeriosemar.dtos.AutenticarMembroResponseDto;
import br.com.ministeriosemar.dtos.CriarMembroRequestDto;
import br.com.ministeriosemar.dtos.CriarMembroResponseDto;
import br.com.ministeriosemar.entities.Membro;
import br.com.ministeriosemar.helpers.Sha1CryptoHelper;
import br.com.ministeriosemar.repositories.MembrosRepository;
import br.com.ministeriosemar.repositories.MinisteriosRepository;
import br.com.ministeriosemar.security.JwtBearerSecurity;

@Service
public class MembroService {


	@Autowired
	MembrosRepository membrosRepository;
	
	@Autowired
	MinisteriosRepository ministeriosRepository;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	/*
	 * Método para criar a conta do usuário
	 */
	public CriarMembroResponseDto criarUsuario(CriarMembroRequestDto request) {


		//verificar se já existe um usuário cadastrado com o email informado
		if(membrosRepository.find(request.getEmail()) != null) {
			throw new IllegalArgumentException("Já existe um usuário cadastrado com o email informado.");
		}
		
		//capturar os dados do usuário
		Membro membro = new Membro();
		membro.setIdUsuario(UUID.randomUUID());
		membro.setNome(request.getNome());
		membro.setEmail(request.getEmail());
		membro.setSenha(Sha1CryptoHelper.get(request.getSenha()));
		membro.setEndereco(request.getEndereco());
		membro.setDataNascimento(request.getDataNascimento());//TODO
		membro.setCargo(request.getCargo());
		membro.setDataBatismo(request.getDataBatismo());
		
		//recupera o UUID do Ministério
		if(ministeriosRepository.find(request.getNomeMinisterio()) != null) {
			
			UUID idPk;
			String lideranca;
			String nome;
			
			
			
		} else {
			
			membro.setMinisterio(null);
		}
		
		//membro.setMinisterio(request.getIdMinisterio());
		membro.setMembroDesde(request.getMembroDesde());
		membro.setSexo(request.getSexo());
		membro.setEstadoCivil(request.getEstadoCivil());
		membro.setDataCasamento(request.getDataCasamento());
		membro.setCelular(request.getCelular());
		membro.setTelefone(request.getTelefone());
		membro.setBatizado(request.isBatizado());
		membro.setNaturalidade(request.getNaturalidade());
		membro.setProfissao(request.getProfissao());
		membro.setEscolaridade(request.getEscolaridade());
		//membro.setGps(request.getIdGps());//TODO
		
		
		
		
		//gravar o usuário no banco de dados
		membrosRepository.save(membro);
		
		//retornar os dados
		CriarMembroResponseDto response = new CriarMembroResponseDto();
		response.setIdUsuario(membro.getIdUsuario());
		response.setNome(membro.getNome());
		response.setEmail(membro.getEmail());
		response.setDataHoraCriacao(Instant.now());
		
		return response;
	}
	
	/*
	 * Método para autenticar o usuário
	 */
	public AutenticarMembroResponseDto autenticarUsuario(AutenticarMembroRequestDto request) {
		
		//buscar o usuário no banco de dados através do email e da senha
		Membro membro = membrosRepository.find(
				request.getEmail(), Sha1CryptoHelper.get(request.getSenha()));
		
		if (membro != null) {
			
			//retornando um DTO contendo os dados do usuário autenticado
			AutenticarMembroResponseDto response = new AutenticarMembroResponseDto();
			
			response.setIdUsuario(membro.getIdUsuario());
			response.setNome(membro.getNome());
			response.setEmail(membro.getEmail());
			response.setDataHoraAcesso(Instant.now());
			response.setDataHoraExpiracao(jwtBearerSecurity.getExpiration().toInstant());
			response.setAccessToken(jwtBearerSecurity.getToken(membro.getEmail()));
			
			return response;
		}
		
		throw new IllegalArgumentException("Acesso negado. Usuário inválido!");
		
	}
}