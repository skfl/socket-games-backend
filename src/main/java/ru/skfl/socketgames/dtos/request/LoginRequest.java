package ru.skfl.socketgames.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
