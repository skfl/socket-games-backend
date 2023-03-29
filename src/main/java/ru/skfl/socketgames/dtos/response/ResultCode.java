package ru.skfl.socketgames.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public enum ResultCode implements Serializable {
    OK("Ok"),
    UNAUTHORIZED("Unauthorized"),
    TOKEN_EXPIRED("TokenExpired"),
    INVALID_TOKEN("InvalidToken"),
    INVALID_CREDENTIALS("InvalidCredentials"),
    CONSTRAINT_VIOLATION("ConstraintViolation"),
    UNEXPECTED_ERROR("UnexpectedError"),
    ASYNC_PROCESSING("AsyncProcessing");



    private String value;
}