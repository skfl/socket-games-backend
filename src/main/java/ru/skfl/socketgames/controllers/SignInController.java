package ru.skfl.socketgames.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skfl.socketgames.dtos.AuthResponse;
import ru.skfl.socketgames.dtos.UserLoginForm;
import ru.skfl.socketgames.services.interfaces.SignInService;

@RestController
@RequestMapping("/signIn")
@RequiredArgsConstructor
public class SignInController {

    private final SignInService signInService;

    @PostMapping
    public ResponseEntity<AuthResponse> signIn(@RequestBody UserLoginForm loginForm){
        return ResponseEntity.ok(signInService.signIn(loginForm));
    }
}
