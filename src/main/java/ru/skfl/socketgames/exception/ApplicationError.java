package ru.skfl.socketgames.exception;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationError {
    private int statusCode;
    private String message;

}
