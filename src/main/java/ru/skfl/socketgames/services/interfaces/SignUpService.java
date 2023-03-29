package ru.skfl.socketgames.services.interfaces;

import ru.skfl.socketgames.dtos.request.SignUpRequest;
import ru.skfl.socketgames.dtos.response.StandardResponse;

public interface SignUpService {
    StandardResponse signUp(SignUpRequest signUpForm);
}
