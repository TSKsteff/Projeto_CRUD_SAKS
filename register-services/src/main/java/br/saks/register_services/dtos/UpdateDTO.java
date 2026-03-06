package br.saks.register_services.dtos;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

@Builder
public record UpdateDTO(
        String name,
        @Email
        String email,
        @CPF
        String cpf,
        String telephone
) {
}
