package com.team.CoverSongChart.Hoony_Api.Dto.Dto_In;

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
