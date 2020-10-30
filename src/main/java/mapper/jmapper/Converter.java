package mapper.jmapper;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import mapper.model.User;
import mapper.model.UserDTO;

import static com.googlecode.jmapper.api.JMapperAPI.*;
import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.global;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

public class Converter {


    public UserDTO convert(User user) {
        JMapperAPI jmapperApi = new JMapperAPI()
            .add(
                mappedClass(UserDTO.class)
                    .add(attribute("password").value("password"))
                    .add(attribute("userName").value("name"))
                .add(attribute("email").value("email"))
                .add(attribute("roleId").value("${role.id}"))
            );

        JMapper<UserDTO, User> userMapper = new JMapper<>(UserDTO.class, User.class, jmapperApi);

        UserDTO userDTO = userMapper.getDestination(user);
        return userDTO;
    }

}
