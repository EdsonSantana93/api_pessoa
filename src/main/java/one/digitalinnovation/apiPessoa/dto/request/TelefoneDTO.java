package one.digitalinnovation.apiPessoa.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import one.digitalinnovation.apiPessoa.entities.enuns.TipoTelefone;

public class TelefoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "Tipo de Telefone é obrigatório")
	private TipoTelefone tipo;
	
	@NotEmpty(message = "Número de Telefone é obrigatório")
	@Size(min = 9, max = 10)
	private Long numero;

	public TelefoneDTO(Long id, TipoTelefone tipo, Long numero) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public TelefoneDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
}
