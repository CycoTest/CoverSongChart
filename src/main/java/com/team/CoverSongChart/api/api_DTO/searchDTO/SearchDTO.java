package com.team.CoverSongChart.api.api_DTO.searchDTO;

import com.team.CoverSongChart.api.api_DTO.searchDTO.detail.PageInfo;
import com.team.CoverSongChart.api.api_DTO.searchDTO.detail.VideoItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchDTO {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfo pageInfo;
    private List<VideoItem> items;
}
