package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skfl.socketgames.dtos.response.StandardResponse;
import ru.skfl.socketgames.services.interfaces.GameInfoService;

@RestController
@RequestMapping("/play")
@RequiredArgsConstructor
public class PlayController {

    private final GameInfoService gameInfoService;

    @GetMapping
    public StandardResponse getGamesList() {
        return gameInfoService.getAllGameInfoData();
    }
}
