package com.team.CoverSongChart.Hoony_Api.Dto;

import com.team.CoverSongChart.Hoony_Api.Dto.Dto_In.PageInfo;
import com.team.CoverSongChart.Hoony_Api.Dto.Dto_In.VideoItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class YouTubeApiResponse {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfo pageInfo;
    private List<VideoItem> items;
}
