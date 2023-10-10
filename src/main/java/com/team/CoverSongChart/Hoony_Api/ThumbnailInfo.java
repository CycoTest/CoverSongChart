package com.team.CoverSongChart.Hoony_Api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThumbnailInfo {
    @JsonProperty("url")
    private String url;
}
