package one.digitalinnovation.apiPessoa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import one.digitalinnovation.apiPessoa.entities.enuns.TipoTelefone;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoTelefone tipo;
	
	@Column(nullable = false)
	private Long numero;

	public Telefone(Long id, TipoTelefone tipo, Long numero) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public Telefone() {
		
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
