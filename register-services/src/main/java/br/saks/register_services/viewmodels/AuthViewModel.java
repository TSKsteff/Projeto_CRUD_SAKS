package br.saks.register_services.viewmodels;

import br.saks.register_services.dtos.AuthResponseDTO;
import br.saks.register_services.dtos.CreateUserDTO;
import br.saks.register_services.dtos.LoginUserDTO;
import br.saks.register_services.securities.SessionContext;
import br.saks.register_services.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.saks.register_services.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthViewModel {

    Logger logger = LogManager.getLogger(UserService.class);

    private final UserFacade userFacade;

    public void login(LoginUserDTO loginUserDTO) {
        logger.info("Attempting login with email: {}", loginUserDTO.email());
        AuthResponseDTO authResponseDTO = userFacade.login(loginUserDTO);
        SessionContext.setToken(authResponseDTO.token());
    }

    public void register(CreateUserDTO dto) {
        logger.info("Registering user with email: {}", dto.email());
        userFacade.register(dto);
    }
}