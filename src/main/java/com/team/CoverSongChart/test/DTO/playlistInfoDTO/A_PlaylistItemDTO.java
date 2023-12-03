package com.team.CoverSongChart.test.DTO.playlistInfoDTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class A_PlaylistItemDTO {
//    private String etag;
    private List<B_PlaylistItem> items;
//    private String kind;
}
