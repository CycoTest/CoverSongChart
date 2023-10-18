//package com.team.CoverSongChart.test.service;
//
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.services.youtube.YouTube;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SearchService {
//
//    private YouTube youTube;
//
//    @Autowired
//    public SearchService(@Value("${youtube.api.key}") String apiKey) {
//        youTube = new YouTube.Builder(
//        )
//                .setApplicationName("CoverSongChart")
//                .setApiKey(apiKey)
//                .build();
//    }
//
//    public YouTube getYouTube() {
//        return youTube;
//    }
//}
