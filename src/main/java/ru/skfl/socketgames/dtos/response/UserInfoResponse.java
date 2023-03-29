package ru.skfl.socketgames.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.skfl.socketgames.dtos.UserDTO;

@Data
@AllArgsConstructor
@Builder
public class UserInfoResponse extends StandardResponse {
    private UserDTO user;
}
