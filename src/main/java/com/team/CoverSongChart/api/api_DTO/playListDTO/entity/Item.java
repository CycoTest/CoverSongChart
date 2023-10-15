package com.team.CoverSongChart.api.api_DTO.playListDTO.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

//@JsonNaming(value = PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Getter
public class Item {
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("snippet")
    private Snippet snippet;

}
