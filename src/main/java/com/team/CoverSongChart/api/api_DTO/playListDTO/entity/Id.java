package com.team.CoverSongChart.api.api_DTO.playListDTO.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
public class Id {
    @JsonProperty("kind")
    private String kind;

//    @JsonProperty("channelId")
//    private String channelId;
//
//    @JsonProperty("id")
//    private String id;
//
//    @JsonProperty("videoId")
//    private String videoId;

    @JsonProperty("playlistId")
    private String playlistId;
}
