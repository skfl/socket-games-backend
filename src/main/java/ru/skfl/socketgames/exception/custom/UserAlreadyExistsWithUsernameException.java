package ru.skfl.socketgames.exception.custom;

public class UserAlreadyExistsWithUsernameException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "User with this username already exists";

    public UserAlreadyExistsWithUsernameException() {
        super(DEFAULT_MESSAGE);
    }

    public UserAlreadyExistsWithUsernameException(String message) {
        super(message);
    }
}
