package com.team.CoverSongChart.Hoony_Api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snippet {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("thumbnails")
    private Thumbnails thumbnails;
}
