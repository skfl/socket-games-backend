package ru.skfl.socketgames.services.interfaces;

import ru.skfl.socketgames.dtos.response.UserInfoResponse;

public interface UserService {
    UserInfoResponse getUserData(String token);
}
