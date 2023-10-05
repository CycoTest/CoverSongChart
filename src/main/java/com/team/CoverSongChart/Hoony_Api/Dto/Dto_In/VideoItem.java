package com.team.CoverSongChart.Hoony_Api.Dto.Dto_In;

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
