package ru.skfl.socketgames.services.interfaces;

import ru.skfl.socketgames.dtos.AuthResponse;
import ru.skfl.socketgames.dtos.UserLoginForm;

public interface SignInService {
    AuthResponse signIn(UserLoginForm loginForm);
}
