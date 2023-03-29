package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skfl.socketgames.dtos.request.LoginRequest;
import ru.skfl.socketgames.dtos.response.AuthResponse;
import ru.skfl.socketgames.services.interfaces.SignInService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/signIn")
public class SignInController {

    private final SignInService signInService;

    @PostMapping("/do")
    public AuthResponse signIn(@RequestBody LoginRequest loginForm) {
        System.err.println("username = "+loginForm.getUsername());
        System.err.println("password = "+loginForm.getPassword());
        return signInService.signIn(loginForm);
    }
}
