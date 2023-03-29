package ru.skfl.socketgames.services.interfaces;

import ru.skfl.socketgames.dtos.response.AuthResponse;
import ru.skfl.socketgames.dtos.request.LoginRequest;

public interface SignInService {
    AuthResponse signIn(LoginRequest loginForm);
}
