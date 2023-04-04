package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skfl.socketgames.dtos.response.GameInfoResponse;
import ru.skfl.socketgames.services.interfaces.GameInfoService;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final GameInfoService gameInfoService;

    @GetMapping("/games")
    @ResponseBody
    public GameInfoResponse getListOfGames(){
        return gameInfoService.getAllGameInfoData();
    }
}
