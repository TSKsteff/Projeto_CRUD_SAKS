package br.saks.register_services.viewmodels;

import br.saks.register_services.Entities.User;
import br.saks.register_services.dtos.UpdateDTO;
import br.saks.register_services.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AdminViewModel {

    private final UserFacade facade;

    public List<User> getALL() {
        return facade.getAllUsers();
    }

    public User getById(Long id) {
        return facade.getUserById(id);
    }

    public String delete(Long id){ return facade.deactivateUser(id);}

    public User updateUser(UpdateDTO user, Long id){return facade.updateUser(user, id);}
}
