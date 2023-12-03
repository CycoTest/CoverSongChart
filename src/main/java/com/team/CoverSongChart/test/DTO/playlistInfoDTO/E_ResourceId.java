package com.team.CoverSongChart.test.DTO.playlistInfoDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class E_ResourceId {
    private String kind;
    private String videoId;
}
