package br.saks.register_services.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
public enum RoleEnum {
	
	USER(1, "User"),
	ADM(2, "Admin");
	
	private final int code;
	private final String  description;
	
	RoleEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
}
