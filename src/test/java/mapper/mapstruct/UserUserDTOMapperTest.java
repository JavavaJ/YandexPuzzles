package mapper.mapstruct;

import mapper.model.Role;
import mapper.model.User;
import mapper.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class UserUserDTOMapperTest {

    @Test
    public void testMapper() {
        UserUserDTOMapper mapper = Mappers.getMapper(UserUserDTOMapper.class);

        User user = buildUser();

        UserDTO userDTO = mapper.userToUserDTO(user);
        System.out.println(userDTO);

        assertThat(userDTO).isNotNull();

        assertThat(
            userDTO.getEmail()
                .equals(
                    user.getEmail()
                )).isTrue();

        assertThat(
            userDTO.getPassword()
                .equals(
                    user.getPassword()
                )).isTrue();
    }

    private User buildUser() {
        Role role = Role.builder()
            .id(666L)
            .name("ADMIN")
            .build();

        User user = User.builder()
            .id(1L)
            .name("Mike")
            .email("mike@mail.com")
            .password("pass")
            .role(role)
            .build();

        return user;
    }

}