package ru.skfl.socketgames.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skfl.socketgames.dtos.GameInfoDTO;
import ru.skfl.socketgames.entities.GameInfo;

@Mapper
public interface GameInfoMapper {
    GameInfoMapper INSTANCE = Mappers.getMapper(GameInfoMapper.class);

    GameInfoDTO toDto(GameInfo gameInfo);

    GameInfo toEntity(GameInfoDTO gameInfoDTO);
}
