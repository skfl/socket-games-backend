package ru.skfl.socketgames.exception.custom;

import lombok.Builder;

public class UserAlreadyExistsWithEmailException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "User with this email already exists";
    public UserAlreadyExistsWithEmailException() {
        super(DEFAULT_MESSAGE);
    }

    public UserAlreadyExistsWithEmailException(String message) {
        super(message);
    }
}
