package one.digitalinnovation.apiPessoa.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import one.digitalinnovation.apiPessoa.entities.Telefone;



public class PessoaDTO {
	
	private Long id;
	
	@NotEmpty(message = "Nome é obrigatório")
	@Size(min = 3, max = 100)
	private String nome;
	
	@NotEmpty(message = "Sobrenome é obrigatório")
	@Size(min = 2, max = 100)
	private String sobrenome;
	
	//@CPF
	private String cpf;
	
	private LocalDate dataNascimento;
	
	@Valid
	@NotEmpty(message = "É necessário informar pelo menos um número de telefone")
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Telefone> telefones;

	public PessoaDTO(Long id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, List<Telefone> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefones = telefones;
	}
	
	public PessoaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}
