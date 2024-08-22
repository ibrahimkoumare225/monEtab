package ci.digitalacademy.monetab.monetab.services.impl;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.debug("Request to upadte user{}",user);
      //  return findOne(user.getId())
                        //     .map(existingUser->{
                         //        existingUser.setPassword(user.getPassword());
                         //     return existingUser;
                           //  }).map(existingUser->{
                           //      return save(existingUser);
        //        }).orElseThrow(()-> new IllegalArgumentException());

        Optional<User> optionalUser = findOne(user.getId());
        if(optionalUser.isPresent()){
            User userToUpdate = optionalUser.get();
            userToUpdate.setPseudo(user.getPseudo());
            userToUpdate.setPassword(user.getPassword());
            return save(userToUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<User> findOne(Long id) {
        log.debug("Request to find on user {}",id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        log.debug("Request to find all users ");
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete user {}",id);
        userRepository.deleteById(id);
    }
}
