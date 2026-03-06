package br.saks.register_services.facades;

import br.saks.register_services.Entities.User;
import br.saks.register_services.dtos.AuthResponseDTO;
import br.saks.register_services.dtos.CreateUserDTO;
import br.saks.register_services.dtos.LoginUserDTO;
import br.saks.register_services.dtos.UpdateDTO;
import br.saks.register_services.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    Logger logger = LogManager.getLogger(UserFacade.class);

    private final UserService userService;
    private final JwtEncoder jwtEncoder;

    private static final long SECONDS_TO_ADD = 3600;



    public AuthResponseDTO login(LoginUserDTO dto) {
        logger.info("FACAD:: Register user request received: email={}", dto.email());

        User user = userService.loginUser(dto);
        String token = getToken(user);

        return new AuthResponseDTO(
                    true,
                    "Login successfully",
                    token, user.getId(), user.getEmail()
            );
    }

    public AuthResponseDTO register(CreateUserDTO dto) {
        logger.info("FACADE:: Login request received: fieldsCreate={}", dto);

        User user = userService.createUser(dto);
        String token = getToken(user);

        return new AuthResponseDTO(
                    true,"User created successfully",
                    token, user.getId(), user.getEmail()
            );

    }

    public User getUserById(Long id) {
        logger.info("FACADE:: Get user by id request received: id={}", id);
        return userService.getUser(id);
    }

    public List<User> getAllUsers() {
        logger.info("FACADE:: Get all active users request received");
        return userService.getAllUser();
    }

    public User updateUser(UpdateDTO dto, Long id) {
        logger.info("FACADE:: Update user request received: id={}, fieldsUpdate={}", id, dto);
        return userService.updateUser(dto, id);
    }

    public String deactivateUser(Long id) {
        logger.info("FACADE:: Deactivate user request received: id={}", id);
        return userService.deleteUser(id);
    }


    private String getToken(User user){
        var claims = JwtClaimsSet.builder()
                .issuer("register-service")
                .subject(user.getId().toString())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(SECONDS_TO_ADD))
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
