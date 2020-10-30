package mapper.model;

import mapper.jmapper.Converter;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    public void testConverter() {
        Converter converter = new Converter();
        User user = buildUser();

        UserDTO userDTO = converter.convert(user);
        System.out.println(userDTO);

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