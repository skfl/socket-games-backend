package ru.skfl.socketgames.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GameInfoDTO {
    private String title;
    private String description;
    private String imgUrl;
    private String playUrl;
}
