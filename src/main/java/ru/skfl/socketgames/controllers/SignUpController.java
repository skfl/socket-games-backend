package ru.skfl.socketgames.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skfl.socketgames.dtos.UserSignUpForm;
import ru.skfl.socketgames.services.interfaces.SignUpService;

@RestController
@RequestMapping("/signUp")
@Validated
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping
    public void signUpUser(@RequestBody @Valid UserSignUpForm signUpForm) {
        signUpService.signUp(signUpForm);
    }
}
