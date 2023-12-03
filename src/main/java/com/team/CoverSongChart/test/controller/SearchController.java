package com.team.CoverSongChart.test.controller;

import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.Video;
import com.team.CoverSongChart.test.DTO.playlistInfoDTO.A_PlaylistItemDTO;
import com.team.CoverSongChart.test.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/csc")
@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam String keyword) throws IOException {
        return searchService.searchAll(keyword);
    }

    // 플레이리스트 가져오기 (겉 표지)
    //
    @GetMapping("/playlist")
    public Playlist getPlaylistById(@RequestParam String playlistId, Model model) throws IOException {
        return searchService.getPlaylist(playlistId);
    }

    // dto 이용 playlist 안에 내용들 가져오기
    // http://localhost:8080/csc/playlistInfo?playlistId=PLOlzssqbfJZhUp5FFVHYaepkba__DfMTC&continue
    @GetMapping("/playlistInfo")
    public A_PlaylistItemDTO getPlaylistInfoInVideo(@RequestParam String playlistId) throws IOException {
        return searchService.getPlaylistInfoInVideo(playlistId);
    }

    // video 1개에 담긴 내용
    @GetMapping("/videoInfo")
    public String getVideoInfo(@RequestParam("videoId") String videoId, Model model) {
        Video video = searchService.getVideoInfo(videoId);
        if (video != null) {
            model.addAttribute("video", video);
            return searchService.getVideoInfo(videoId).toString();
        } else {
            return "error"; // 에러 페이지로 리다이렉트 또는 표시
        }
    }
}




//    @GetMapping("/playlistInfo")
//    public PlaylistItemListResponse getPlaylistInfoInVideo(@RequestParam String playlistId) throws IOException {
//        return searchService.getPlaylistInfoInVideo(playlistId);
//    }


    //    @GetMapping("/music/list")
//    public List<PlaylistItem> getPlaylistItems(@RequestParam String keyword) throws IOException {
//        return searchService.getPlaylistItems(keyword);
//    }
//
//    @GetMapping("/popular")
//    public String popularVideo() throws IOException {
//        return searchService.getPopularVideo();
//    }

//    @GetMapping("/playlistInfoDetail")
//    public String getPlaylistInfoDetail(@RequestParam("playlistId") String playlistId, Model model) {
//        List<String> videoList = searchService.getVideosInPlaylistDetail(playlistId);
//
//        if (!videoList.isEmpty()) {
//            model.addAttribute("videoList", videoList); // 동영상 목록을 모델에 추가
//            return searchService.getVideosInPlaylistDetail(playlistId).toString();
//        } else {
//            return "error"; // 에러 페이지로 리다이렉트 또는 표시
//        }
//    }


