package com.team.CoverSongChart.test.DTO.playlistInfoDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class F_Thumbnails {
//    private G_Thumbnail defaultThumbnail;
//    private G_Thumbnail high;
//    private G_Thumbnail maxres;
//    private G_Thumbnail medium;
    private G_Thumbnail standard;
}
