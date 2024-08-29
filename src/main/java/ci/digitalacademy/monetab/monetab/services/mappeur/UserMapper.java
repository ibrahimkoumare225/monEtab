package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.User;
import ci.digitalacademy.monetab.monetab.services.dto.UserDTO;

public final class UserMapper {

    private UserMapper(){}

    public static UserDTO toDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPseudo(user.getPseudo());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreationdate(user.getCreationdate());
        return userDTO;
    }
    public static User toEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setPseudo(userDTO.getPseudo());
        user.setPassword(userDTO.getPassword());
        user.setCreationdate(userDTO.getCreationdate());
        return user;
    }
}
