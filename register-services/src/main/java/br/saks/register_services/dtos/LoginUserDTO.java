package br.saks.register_services.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginUserDTO(

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password
) {
}
