package one.digitalinnovation.apiPessoa.entities.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
	FIXO(1), CELULAR(2), COMERCIAL(3);

//	private final String description;
	private int code;

	private TipoTelefone(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoTelefone valueOf(int code) {
		for (TipoTelefone value : TipoTelefone.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("O valor passado é invalido!");
	}
}
