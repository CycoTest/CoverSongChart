package com.team.CoverSongChart.Hoony_Api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Thumbnails {
    @JsonProperty("default")
    private ThumbnailInfo defaultThumbnail;
}
