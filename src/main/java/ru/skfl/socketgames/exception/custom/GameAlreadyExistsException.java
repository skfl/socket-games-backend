package ru.skfl.socketgames.exception.custom;

import lombok.NoArgsConstructor;

public class GameAlreadyExistsException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "This game is already exists";

    public GameAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }
}
