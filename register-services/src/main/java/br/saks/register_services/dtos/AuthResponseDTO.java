package br.saks.register_services.dtos;

public record AuthResponseDTO(
        boolean success,
        String message,
        String token,
        Long userId,
        String email
) {
}
