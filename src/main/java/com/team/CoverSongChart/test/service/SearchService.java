package com.team.CoverSongChart.test.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
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

        String searchQuery = keyword + "cover";
        search.setQ(searchQuery);
        search.setType("video"); // 동영상 결과만 필터링
        search.setVideoCategoryId("10"); // "음악" 카테고리 ID 설정
        search.setMaxResults(5L); // 검색제한 갯수 원하면 하기

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


    // 한국 최근 인기영상들 가져오기
    public String getPopularVideo() throws IOException {
        YouTube.Videos.List videoRequest = youtube.videos().list("snippet");
        videoRequest.setRegionCode("KR"); // 한국 지역 코드
        videoRequest.setChart("mostPopular");
        videoRequest.setMaxResults(100L); // 원하는 결과 수로 수정

        VideoListResponse videoResponse = videoRequest.execute();
        return videoResponse.toPrettyString();
    }


    ///////////////

    // playlist 겉 표지
    // http://localhost:8080/csc/playlist?playlistId=PLOlzssqbfJZhUp5FFVHYaepkba__DfMTC
    public Playlist getPlaylist(String playlistId) throws IOException {
        return youtube.playlists().list("snippet")
                .setId(playlistId)
                .execute()
                .getItems()
                .get(0);
    }

    // playlist 안에 담긴 videoId에 대한 정보만 가져오기
    // 아래 예시
    // http://localhost:8080/csc/playlistInfo?playlistId=PLOlzssqbfJZhUp5FFVHYaepkba__DfMTC
    public PlaylistItemListResponse getPlaylistInfoInVideo(String playlistId) throws IOException {
        return youtube.playlistItems().list("snippet")
                .setPlaylistId(playlistId)
                .execute();
    }

    // VideoId에 대한 것 가져오기
    // 아래 예시
    // http://localhost:8080/csc/videoInfo?videoId=3gn31nL_UVc
    public Video getVideoInfo(String videoId) {
        try {
            YouTube.Videos.List videosListRequest = youtube.videos().list("snippet");
            videosListRequest.setId(videoId);
            VideoListResponse videoListResponse = videosListRequest.execute();
            return videoListResponse.getItems().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // 내꺼 playlist 가져오기 23.11
//    public Playlist getPlaylistInfo(String playlistId) {
//        try {
//            // 플레이리스트 정보 가져오기
//            YouTube.Playlists.List playlistsListRequest = youtube.playlists().list("snippet");
//            playlistsListRequest.setId(playlistId); // 플레이리스트 ID 입력
//            PlaylistListResponse playlistsListResponse = playlistsListRequest.execute();
//            return playlistsListResponse.getItems().get(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    //    public List<String> getVideosInPlaylistDetail(String playlistId) {
//        try {
//            YouTube.PlaylistItems.List playlistItemsRequest = youtube.playlistItems().list("snippet");
//            playlistItemsRequest.setPlaylistId(playlistId);
//            PlaylistItemListResponse playlistItemListResponse = playlistItemsRequest.execute();
//
//            List<String> videoList = new ArrayList<>();
//            for (PlaylistItem playlistItem : playlistItemListResponse.getItems())
//                videoList.add(playlistItem.getSnippet().getResourceId().getVideoId());
//
//            return videoList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }

}
