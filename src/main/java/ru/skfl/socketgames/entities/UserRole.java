package ru.skfl.socketgames.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");
    private String value;
}
