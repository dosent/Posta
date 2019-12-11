package dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.neshin.posta.model.UserModel;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "login", target = "login"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "id", target = "user_id")
    })
    UserDto userToUserDto(UserModel user);

    List<UserDto> userToUserDto(List<UserModel> users);
}
