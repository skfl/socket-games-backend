package ru.skfl.socketgames.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserState {
    NOT_CONFIRMED("NOT_CONFIRMED"),
    DELETED("DELETED"),
    CONFIRMED("CONFIRMED"),
    BANNED("BANNED");
    private String value;
}
