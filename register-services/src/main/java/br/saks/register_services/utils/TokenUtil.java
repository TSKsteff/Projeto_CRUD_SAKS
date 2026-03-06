package br.saks.register_services.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenUtil {

    private final JwtDecoder jwtDecoder;

    public Jwt decode(String token) {
        return jwtDecoder.decode(token);
    }

    public String getEmail(String token) {
        return decode(token).getClaim("email");
    }

    public String getRole(String token) {
        return decode(token).getClaim("role");
    }

    public Long getUserId(String token) {

        Jwt jwt = decode(token);

        log.info("Decoded user id from token: {}", jwt.getSubject());

        return Long.valueOf(jwt.getSubject());
    }
}