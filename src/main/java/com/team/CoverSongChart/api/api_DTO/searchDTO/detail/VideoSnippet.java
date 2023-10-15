package com.team.CoverSongChart.api.api_DTO.searchDTO.detail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoSnippet {

    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Thumbnails thumbnails;

    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;
}
