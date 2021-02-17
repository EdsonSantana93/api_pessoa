package one.digitalinnovation.apiPessoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.apiPessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apiPessoa.exception.PessoaNotFoundException;
import one.digitalinnovation.apiPessoa.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@PostMapping("/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public String inserirPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
		service.incluirPessoa(pessoaDTO);
		return "Criado com sucesso!";
	}

	@GetMapping
	public List<PessoaDTO> buscarPessoas() {
		return service.buscarPessoas();
	}
	
	@GetMapping("/{id}")
	public PessoaDTO buscarPessoaPorId(@PathVariable Long id) throws PessoaNotFoundException {
		return service.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirPessoa(@PathVariable Long id) throws PessoaNotFoundException {
		service.excluirPessoa(id);
	}
	
	@PutMapping("/{id}")
	public String atualizarPessoa(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNotFoundException {
		service.AtualizarPessoa(id, pessoaDTO);
		return "Dados atualizados!";
	}
}
