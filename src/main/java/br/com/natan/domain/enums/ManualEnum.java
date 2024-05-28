package br.com.natan.domain.enums;

import lombok.Getter;

@Getter
public enum ManualEnum {

	//FAISCA
	SALTADOR(1),
	CAMINHANTE(2),
	ESCALADOR(3),
	
	//FLAMA
	SABIÁ(4),
	ÁGUIA(5),
	
	//TOCHA
	CARNEIRO(6),
	LEÃO(7);
	
	
	private Integer code;
	
	ManualEnum(Integer code){
		this.code = code;
	}
	
	public static ManualEnum fromCode(Integer code) {
		for(ManualEnum e : ManualEnum.values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Código enum desconhecido: " + code);
	}
}
