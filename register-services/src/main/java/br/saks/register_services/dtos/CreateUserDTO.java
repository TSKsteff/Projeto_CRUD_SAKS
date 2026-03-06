package br.saks.register_services.dtos;

import br.saks.register_services.enums.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Builder
public record CreateUserDTO(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String name,

        @NotBlank
        @Length(max = 8)
        String password,

        @NotBlank
        @CPF
        String cpf,

        @NotBlank
        String telephone,

        RoleEnum role,

        Boolean active
) {
}