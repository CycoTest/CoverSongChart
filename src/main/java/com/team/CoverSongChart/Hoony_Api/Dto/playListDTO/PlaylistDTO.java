package com.team.CoverSongChart.Hoony_Api.Dto.playListDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaylistDTO {
    private String playlistId;
    private String title;
    private String description;
    private String thumbnailUrl;

    public PlaylistDTO() {

    }
}
