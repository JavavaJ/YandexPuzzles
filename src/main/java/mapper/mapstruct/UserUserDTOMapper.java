package mapper.mapstruct;

import mapper.model.User;
import mapper.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserUserDTOMapper {

    @Mappings({
        @Mapping(target = "userName", source = "user.name"),
        @Mapping(target = "roleId", source = "user.role.id")
    })
    UserDTO userToUserDTO(User user);

}
