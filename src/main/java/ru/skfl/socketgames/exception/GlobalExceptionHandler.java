package ru.skfl.socketgames.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
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
