package ci.digitalacademy.monetab.monetab.repositories;

import ci.digitalacademy.monetab.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
