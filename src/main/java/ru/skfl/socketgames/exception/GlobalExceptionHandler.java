package ru.skfl.socketgames.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.skfl.socketgames.exception.custom.SignInCredentialException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchSignInCredentialsException(InternalAuthenticationServiceException e) {
        log.error(e.getMessage(), e);
        System.err.println("catch");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApplicationError.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message(e.getMessage()).build());
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationError> catchException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(ApplicationError.builder()
                        .statusCode(HttpStatus.I_AM_A_TEAPOT.value())
                        .message(e.getMessage()).build());
    }
}
