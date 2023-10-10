package com.team.CoverSongChart.Hoony_Api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Id {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("playlistId")
    private String playlistId;
}
