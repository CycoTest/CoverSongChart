package com.team.CoverSongChart.test.controller;

import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.Video;
import com.team.CoverSongChart.test.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/csc")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam String keyword) throws IOException {
        return searchService.searchAll(keyword);
    }

    @GetMapping("/music/list")
    public List<PlaylistItem> getPlaylistItems(@RequestParam String keyword) throws IOException {
        return searchService.getPlaylistItems(keyword);
    }

    @GetMapping("/popular")
    public String popularVideo() throws IOException {
        return searchService.getPopularVideo();
    }




    // 플레이리스트 가져오기
    @GetMapping("/playlist")
    public Playlist getPlaylistById(@RequestParam String playlistId, Model model) throws IOException {
        return searchService.getPlaylist(playlistId);
    }

    @GetMapping("/playlistInfo")
    public PlaylistItemListResponse getPlaylistInfoInVideo(@RequestParam String playlistId) throws IOException {
        return searchService.getPlaylistInfoInVideo(playlistId);
    }

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
}

