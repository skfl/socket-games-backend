package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skfl.socketgames.dtos.GameInfoDTO;
import ru.skfl.socketgames.dtos.response.StandardResponse;
import ru.skfl.socketgames.services.interfaces.GameInfoService;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final GameInfoService gameInfoService;

    @PostMapping("/games/add")
    public StandardResponse addGame(@RequestBody GameInfoDTO gameInfo) {
        return gameInfoService.addGameInfo(gameInfo);
    }
}
