package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.skfl.socketgames.dtos.response.UserInfoResponse;
import ru.skfl.socketgames.services.interfaces.UserService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public UserInfoResponse getUserData(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.getUserData(token);
    }
}
