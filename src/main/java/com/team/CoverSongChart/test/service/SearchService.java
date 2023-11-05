package com.team.CoverSongChart.test.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SearchService {

    private final YouTube youtube;

    public String searchAll(String keyword) throws IOException {
        YouTube.Search.List search = youtube.search().list("snippet");

        String searchQuery = keyword + "cover";

        search.setQ(searchQuery);
        search.setType("video"); // 동영상 결과만 필터링
        search.setVideoCategoryId("10"); // "음악" 카테고리 ID 설정

        // if-else
        // 음악으로 두고
        // 그 다음에는 cover, cover song, 커버

        search.setMaxResults(5L); // 검색제한 갯수 원하면 하기

        SearchListResponse searchResponse = search.execute();
        return searchResponse.toPrettyString();

        //GSON 이용
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String prettyJson = gson.toJson(gson);

//        return prettyJson;
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


    // 내꺼 playlist 가져오기 23.11

    public Playlist getPlaylistInfo(String playlistId) {
        try {
            // 플레이리스트 정보 가져오기
            YouTube.Playlists.List playlistsListRequest = youtube.playlists().list("snippet");
            playlistsListRequest.setId(playlistId); // 플레이리스트 ID 입력
            PlaylistListResponse playlistsListResponse = playlistsListRequest.execute();
            return playlistsListResponse.getItems().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<String> getVideosInPlaylistDetail(String playlistId) {
        try {
            YouTube.PlaylistItems.List playlistItemsRequest = youtube.playlistItems().list("snippet");
            playlistItemsRequest.setPlaylistId(playlistId);
            PlaylistItemListResponse playlistItemListResponse = playlistItemsRequest.execute();

            List<String> videoList = new ArrayList<>();
            for (PlaylistItem playlistItem : playlistItemListResponse.getItems())
                videoList.add(playlistItem.getSnippet().getResourceId().getVideoId());

            return videoList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
