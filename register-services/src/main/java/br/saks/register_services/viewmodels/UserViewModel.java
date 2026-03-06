package br.saks.register_services.viewmodels;

import br.saks.register_services.Entities.User;
import br.saks.register_services.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserViewModel {

    private final UserFacade facade;

    public User getById(Long id) {
        return facade.getUserById(id);
    }
}