package ru.skfl.socketgames.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginForm {
    private String username;
    private String password;
}
