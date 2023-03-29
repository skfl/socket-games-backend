package ru.skfl.socketgames.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skfl.socketgames.dtos.GameInfoDTO;
import ru.skfl.socketgames.entities.GameInfo;
import ru.skfl.socketgames.exception.custom.GameAlreadyExistsException;
import ru.skfl.socketgames.repository.GameInfoRepository;
import ru.skfl.socketgames.dtos.response.GameInfoResponse;
import ru.skfl.socketgames.dtos.response.ResponseInfo;
import ru.skfl.socketgames.dtos.response.ResultCode;
import ru.skfl.socketgames.services.interfaces.GameInfoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameInfoServiceImpl implements GameInfoService {

    private final GameInfoRepository gameInfoRepository;

    @Override
    public GameInfoResponse getAllGameInfoData() {
        List<GameInfoDTO> gameInfo = gameInfoRepository
                .findAll()
                .stream()
                .map((entity) -> GameInfoDTO.builder().description(entity.getDescription())
                        .title(entity.getTitle())
                        .imgUrl(entity.getImgUrl())
                        .build())
                .toList();
        return new GameInfoResponse(ResponseInfo.getInstance(ResultCode.OK), gameInfo);
    }

    @Override
    public GameInfoResponse addGameInfo(GameInfoDTO gameInfoDTO) {
        if (gameInfoRepository.existsByTitle(gameInfoDTO.getTitle().trim())) {
            throw new GameAlreadyExistsException();
        }
        GameInfo gameInfo = GameInfo.builder()
                .description(gameInfoDTO.getDescription())
                .title(gameInfoDTO.getTitle().trim())
                .imgUrl(gameInfoDTO.getImgUrl()).build();
        gameInfoRepository.save(gameInfo);
        return new GameInfoResponse(ResponseInfo.getInstance(ResultCode.OK, "Game info saved"), List.of(gameInfoDTO));
    }
}
