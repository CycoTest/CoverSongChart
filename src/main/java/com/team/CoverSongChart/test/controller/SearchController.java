//package com.team.CoverSongChart.test.controller;
//
//import com.google.api.services.youtube.YouTube;
//import com.google.api.services.youtube.model.SearchListResponse;
//import com.team.CoverSongChart.test.service.SearchService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class SearchController {
//
//    private final SearchService searchService;
//
//
//    @Value("${youtube.api.key}")
//    private String apiKey;
//
//    @GetMapping("/youtube-data")
//    public SearchListResponse getYoutubeData(@RequestParam(name = "search") String searchQuery) {
//        try {
//            YouTube youtube = searchService.getYouTube();
//            YouTube.Search.List search = youtube.search().list("id,snippet");
//            search.setQ(searchQuery); // 쿼리 매개변수에서 전달받은 검색어를 사용
//            search.setKey(apiKey);
//            search.setMaxResults(10L);
//            return search.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
