package ci.digitalacademy.monetab.monetab.security;

import ci.digitalacademy.monetab.monetab.models.RoleUser;
import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class DomainUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String pseudo)  {

        final Optional<User> user = userRepository.findByPseudo(pseudo);
        if (!user.isPresent()){
            throw new IllegalArgumentException("User not found");
        }
        final List<GrantedAuthority> grantedAuthorities = user.get()
                .getRoleUser()
                .stream()
                .map(RoleUser::getNameRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return user.map(userRecover ->org.springframework.security.core.userdetails.User.builder()
                .username(userRecover.getPseudo())
                .password(userRecover.getPassword())
                .authorities(grantedAuthorities)
                //.roles()
                .build()).orElseThrow(() -> new IllegalArgumentException("User not found"));

    }
}
