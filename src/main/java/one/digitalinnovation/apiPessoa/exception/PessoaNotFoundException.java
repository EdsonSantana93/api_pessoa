package one.digitalinnovation.apiPessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(Long id) {
		super("Nenhuma pessoa foi encontrada com o id: " + id);
	}
}
