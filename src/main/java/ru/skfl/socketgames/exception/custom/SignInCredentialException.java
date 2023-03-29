package ru.skfl.socketgames.exception.custom;

 import org.springframework.security.core.AuthenticationException;

public class SignInCredentialException extends AuthenticationException {
    private static final String DEFAULT_MESSAGE = "Wrong credentials!!!";

    public SignInCredentialException() {
        super(DEFAULT_MESSAGE);
    }
}
