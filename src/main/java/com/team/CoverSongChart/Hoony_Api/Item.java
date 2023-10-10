package com.team.CoverSongChart.Hoony_Api;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Item {
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("snippet")
    private Snippet snippet;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;

}
