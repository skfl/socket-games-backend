package ru.skfl.socketgames.services.interfaces;

import ru.skfl.socketgames.dtos.GameInfoDTO;
import ru.skfl.socketgames.dtos.response.GameInfoResponse;

public interface GameInfoService {
    GameInfoResponse getAllGameInfoData();

    GameInfoResponse addGameInfo(GameInfoDTO gameInfoDTO);
}
