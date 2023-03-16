package ru.skfl.socketgames.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skfl.socketgames.dtos.UserDTO;
import ru.skfl.socketgames.entities.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toEntity(UserDTO dto);
}
