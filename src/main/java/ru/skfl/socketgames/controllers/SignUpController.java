package ru.skfl.socketgames.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skfl.socketgames.dtos.AuthResponse;
import ru.skfl.socketgames.dtos.UserSignUpForm;
import ru.skfl.socketgames.services.interfaces.SignUpService;

@RestController
@RequestMapping("/signUp")
@Validated
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<AuthResponse> signUpUser(@RequestBody @Valid UserSignUpForm signUpForm) {
        return ResponseEntity.ok(new AuthResponse("www"));
    }
}
