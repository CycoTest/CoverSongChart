package com.team.CoverSongChart.test.DTO.playlistInfoDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class B_PlaylistItem {
//    private String etag;
//    private String id;
//    private String kind;
    private C_Snippet snippet;
}
