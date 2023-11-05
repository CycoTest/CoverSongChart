package com.team.CoverSongChart.test.controller;

import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.team.CoverSongChart.test.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/playlistInfo")
    public String getPlaylistInfo(@RequestParam("playlistId") String playlistId, Model model) {
        Playlist playlist = searchService.getPlaylistInfo(playlistId);
        if (playlist != null) {
            model.addAttribute("playlist", playlist);
            return searchService.getPlaylistInfo(playlistId).toString();
        } else {
            return "error"; // 에러 페이지로 리다이렉트 또는 표시
        }
    }


    @GetMapping("/playlistInfoDetail")
    public String getPlaylistInfoDetail(@RequestParam("playlistId") String playlistId, Model model) {
        List<String> videoList = searchService.getVideosInPlaylistDetail(playlistId);

        if (!videoList.isEmpty()) {
            model.addAttribute("videoList", videoList); // 동영상 목록을 모델에 추가
            return searchService.getVideosInPlaylistDetail(playlistId).toString();
        } else {
            return "error"; // 에러 페이지로 리다이렉트 또는 표시
        }
    }
}

