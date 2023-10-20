package com.team.CoverSongChart.test.controller;

import com.google.api.services.youtube.model.PlaylistItem;
import com.team.CoverSongChart.test.service.SearchService;
import lombok.RequiredArgsConstructor;
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
}

