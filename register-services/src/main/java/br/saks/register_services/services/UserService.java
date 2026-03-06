package br.saks.register_services.services;

import br.saks.register_services.dtos.CreateUserDTO;
import br.saks.register_services.dtos.LoginUserDTO;
import br.saks.register_services.dtos.UpdateDTO;
import br.saks.register_services.exceptions.ApiException;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.saks.register_services.Entities.User;
import br.saks.register_services.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	
	Logger logger = LogManager.getLogger(UserService.class);

	
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    		
    public User createUser(CreateUserDTO createUserDTO) {
        logger.info("CREATE USER - Request received: fieldsToCreate={}", createUserDTO);

        return userRepository.save(
                User.builder()
                .name(createUserDTO.name())
                .email(createUserDTO.email())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .cpf(createUserDTO.cpf())
                .telephone(createUserDTO.telephone())
                .role(createUserDTO.role())
                .active(createUserDTO.active())
                .build()
        );
    }

    public User loginUser(LoginUserDTO loginUserDTO) {
        logger.info("LOGIN - Request received: email={}", loginUserDTO.email());
        User user = this.getUserInfo(loginUserDTO.email());

        if (!verifyPassword(loginUserDTO, user)) {
            throw new ApiException(
                    "Email or password incorrect",
                    "BAD_REQUEST");
        }
        return user;
    }
    
    public User updateUser(UpdateDTO updateDTO, Long id) {
        logger.info("UPDATE USER - Request received: userId={}, fieldsToUpdate={}", id, updateDTO);

        User user = getUser(id);
        user.setCpf(
                updateDTO.cpf() == null || updateDTO.cpf().isBlank()
                        ? user.getCpf()
                        : updateDTO.cpf()
        );
        user.setEmail(
                updateDTO.email() == null || updateDTO.email().isBlank()
                        ? user.getEmail()
                        : updateDTO.email()
        );
        user.setName(
                updateDTO.name() == null || updateDTO.name().isBlank()
                        ? user.getName()
                        : updateDTO.name()
        );
        user.setTelephone(
                updateDTO.telephone() == null || updateDTO.telephone().isBlank()
                        ? user.getTelephone()
                        : updateDTO.telephone()
        );
        return userRepository.save(user);
    }
    
    public User getUser(Long id) {
        logger.info("GET USER BY ID - Request received: userId={}", id);
        return userRepository.findById(id).orElseThrow(() -> new ApiException("id not found", "NOT_FOUND"));
    }
    
    public List<User> getAllUser(){
        logger.info("GET All User - Request filter User Active");
    	return userRepository.findAllUsers();
    }
    
    public String deleteUser(Long id) {
        logger.info("DEACTIVATE USER - Request received: userId={}", id);

        var user = getUser(id);
        user.setActive(false);
    	userRepository.save(user);
        return String.format("User '%s' (ID: %d) successfully deactivated %s",
                user.getName(),
                user.getId(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    private User getUserInfo(String email) {
        logger.info("GET USER BY EMAIL - Request received: email={}", email);
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new ApiException("Not found email", "NOT_FOUND")
        );
    }

    public boolean verifyPassword(LoginUserDTO loginDto, User user) {
        return passwordEncoder.matches(loginDto.password(), user.getPassword());
    }
}
