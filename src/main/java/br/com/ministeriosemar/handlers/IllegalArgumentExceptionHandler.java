package br.com.ministeriosemar.handlers;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.ministeriosemar.dtos.ErrorResponseDto;

@ControllerAdvice
public class IllegalArgumentExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class) // erro que será capturado
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	
	public ErrorResponseDto handleIllegalArgumentException(IllegalArgumentException e) {
		
		ErrorResponseDto response = new ErrorResponseDto();
		
		System.out.println("");
		System.out.println("---CLASSE IllegalArgumentExceptionHandler---");
		System.out.println("STRING DO ERRO: " + e.getMessage());
		System.out.println("");
		
		/*
		 * if (e.getMessage() != null &&
		 * "Acesso negado. Usuário inválido!".equalsIgnoreCase(e.getMessage())) {
		 * 
		 * @ResponseStatus(HttpStatus.BAD_REQUEST)
		 * 
		 * 
		 * 
		 * }
		 */
		
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setErrors(new ArrayList<String>());
		response.getErrors().add(e.getMessage());
		
		return response;
	}
}