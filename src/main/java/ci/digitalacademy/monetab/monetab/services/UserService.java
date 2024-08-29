package ci.digitalacademy.monetab.monetab.services;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(UserDTO userDTO);


    UserDTO update(UserDTO userDTO);


    Optional<UserDTO> findOne(Long id);

    List<UserDTO> findAll();

    void delete(Long id);
}
