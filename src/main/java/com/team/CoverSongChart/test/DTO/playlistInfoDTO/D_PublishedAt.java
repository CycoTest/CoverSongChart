package com.team.CoverSongChart.test.DTO.playlistInfoDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class D_PublishedAt {
    private long value;
    private boolean dateOnly;
    private int timeZoneShift;
}
