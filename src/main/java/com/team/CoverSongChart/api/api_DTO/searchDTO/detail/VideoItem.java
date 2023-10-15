package com.team.CoverSongChart.api.api_DTO.searchDTO.detail;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoItem {

    private String kind;
    private String etag;
    private JsonNode id;
    private VideoSnippet snippet;
}
