package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    List<UserDTO > initUser(List<UserDTO> users);

    UserDTO update(UserDTO userDTO);

    Optional<UserDTO> findByPseudo(String username);

    Optional<UserDTO> findOne(Long id);

    List<UserDTO> findAll();

    void delete(Long id);
    List<UserDTO> findByCreatedDateLessThanAndRoleUserNameRole(Instant createdDate, String roles);
}
