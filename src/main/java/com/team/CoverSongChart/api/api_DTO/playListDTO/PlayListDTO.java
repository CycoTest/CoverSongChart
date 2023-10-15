package com.team.CoverSongChart.api.api_DTO.playListDTO;

import com.team.CoverSongChart.api.api_DTO.playListDTO.entity.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayListDTO {
//    private String videId;
//    private String playlistId;
//    private String description;
//    private String thumbnailUrl;
    private List<Item> items;

    public PlayListDTO() {

    }
}
