package ru.skfl.socketgames.dtos.response;

import lombok.Data;
import ru.skfl.socketgames.dtos.GameInfoDTO;

import java.util.List;

@Data
public class GameInfoResponse extends StandardResponse {
    private List<GameInfoDTO> gameInfo;


    public GameInfoResponse(ResponseInfo responseInfo, List<GameInfoDTO> gameInfo) {
        super(responseInfo);
        this.gameInfo = gameInfo;
    }
}
