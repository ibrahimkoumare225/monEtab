package ci.digitalacademy.monetab.monetab.repositories;

import ci.digitalacademy.monetab.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPseudo(String pseudo);
    List<User> findByCreatedDateLessThanAndRoleUserNameRole(Instant createdDate, String roles);
}
