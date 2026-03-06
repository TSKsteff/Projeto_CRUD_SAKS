package br.saks.register_services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saks.register_services.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.role = 'USER' AND u.active = true")
    List<User> findAllUsers();
}
