package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TicTacToeController {

    @MessageMapping("/tictactoe")
    @SendTo("/topic/tictactoe")
    public String test() {
        return "Hello from socket";
    }
}
