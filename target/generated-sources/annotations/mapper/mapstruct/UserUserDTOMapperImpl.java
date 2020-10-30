package mapper.mapstruct;

import javax.annotation.Generated;
import mapper.model.Role;
import mapper.model.User;
import mapper.model.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-15T21:20:12+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class UserUserDTOMapperImpl implements UserUserDTOMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName( user.getName() );
        userDTO.setRoleId( userRoleId( user ) );
        userDTO.setPassword( user.getPassword() );
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }

    private Long userRoleId(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
