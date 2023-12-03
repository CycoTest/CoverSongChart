package com.team.CoverSongChart.test.DTO.playlistInfoDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class C_Snippet {
//    private String channelId;
    private String channelTitle;
//    private String description;
    private String playlistId;
//    private int position;
//    private D_PublishedAt publishedAt;
    private E_ResourceId resourceId;
    private F_Thumbnails thumbnails;
    private String title;
    private String videoOwnerChannelTitle;
//    private String videoOwnerChannelId;
}
