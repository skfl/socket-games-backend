package ru.skfl.socketgames.services.interfaces;

import ru.skfl.socketgames.dtos.UserDTO;
import ru.skfl.socketgames.dtos.UserSignUpForm;

public interface SignUpService {
    UserDTO signUp(UserSignUpForm signUpForm);
}
