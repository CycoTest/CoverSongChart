package com.team.CoverSongChart.Hoony_Api.Dto.Dto_In;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thumbnails {

    @JsonProperty("default")
    private ThumbnailDetails defaultThumbnail;
    @JsonProperty("medium")
    private ThumbnailDetails mediumThumbnail;
    @JsonProperty("high")
    private ThumbnailDetails highThumbnail;
}
