package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.monetab.services.UserService;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.monetab.services.mappeur.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final UserMapper userMapper;


    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }


    @Override
    public List<UserDTO> initUser(List<UserDTO> users) {
        List<UserDTO > usersDto = findAll();
        if (usersDto.isEmpty()){
            users.forEach(user->{
                save(user);
            });
        }
        return findAll();

    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        log.debug("Request to upadte userDTO{}",userDTO);
        return findOne(userDTO.getId()).map(existingUser->{
            existingUser.setPseudo(userDTO.getPseudo());
            existingUser.setPassword(userDTO.getPassword());
            return save(existingUser);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<UserDTO> findByPseudo(String pseudo) {

        return userRepository.findByPseudo(pseudo).map(user -> userMapper.toDto(user));
    }
    @Override
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to find on user {}",id);
        return userRepository.findById(id).map(user -> {
        return userMapper.toDto(user);
        });
    }

    @Override
    public List<UserDTO> findAll() {
        log.debug("Request to find all users ");
        return userRepository.findAll().stream().map(user -> {
                return userMapper.toDto(user);
    }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete user {}",id);
        userRepository.deleteById(id);
    }


    @Override
    public List<UserDTO> findByCreatedDateLessThanAndRoleUserNameRole(Instant createdDate, String role) {
        List<User> users = userRepository.findByCreatedDateLessThanAndRoleUserNameRole(createdDate, role);
        return users.stream().map(user -> userMapper.toDto(user)).toList();
    }
}
