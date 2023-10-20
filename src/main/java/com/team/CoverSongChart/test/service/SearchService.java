package com.team.CoverSongChart.test.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SearchService {

    private final YouTube youtube;

    public String searchAll(String keyword) throws IOException {
        YouTube.Search.List search = youtube.search().list("snippet");
        search.setQ(keyword);
        search.setType("video"); // 동영상 결과만 필터링
        search.setVideoCategoryId("10"); // "음악" 카테고리 ID 설정

        // if-else
        // 음악으로 두고
        // 그 다음에는 cover, cover song, 커버

        search.setMaxResults(10L); // 검색제한 갯수 원하면 하기

        SearchListResponse searchResponse = search.execute();
        return searchResponse.toPrettyString();
    }

    public List<PlaylistItem> getPlaylistItems(String playlistId) throws IOException {
        YouTube.PlaylistItems.List request = youtube.playlistItems().list("snippet");
        request.setPlaylistId(playlistId);
        request.setMaxResults(10L);

        PlaylistItemListResponse playlistItemListResponse = request.execute();
        return playlistItemListResponse.getItems();
    }


    public String getPopularVideo() throws IOException {
        YouTube.Videos.List videoRequest = youtube.videos().list("snippet");
        videoRequest.setRegionCode("KR"); // 한국 지역 코드
        videoRequest.setChart("mostPopular");
        videoRequest.setMaxResults(100L); // 원하는 결과 수로 수정

        VideoListResponse videoResponse = videoRequest.execute();
        return videoResponse.toPrettyString();
    }
}
