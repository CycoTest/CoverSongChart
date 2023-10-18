package com.team.CoverSongChart.test2.controller;

import com.team.CoverSongChart.test2.service.YouTubeSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class YouTubeSearchController {

    private final YouTubeSearchService searchService;

    @GetMapping("/search")
    public String searchShortBox(@RequestParam String keyword) throws IOException {
        return searchService.searchShortBox(keyword);
    }
}
