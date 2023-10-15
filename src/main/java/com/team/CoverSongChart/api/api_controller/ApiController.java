package com.team.CoverSongChart.api.api_controller;

import com.team.CoverSongChart.api.api_DTO.playListDTO.PlayListDTO;
import com.team.CoverSongChart.api.api_DTO.playListDTO.entity.Item;
import com.team.CoverSongChart.api.api_DTO.searchDTO.SearchDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Value("${youtube.api.key}")
    private String apiKey;

    @GetMapping("/search")
    public Mono<SearchDTO> search(@RequestParam String keyword) {
        return WebClient.builder().baseUrl("https://www.googleapis.com/youtube/v3/")
                .build().get()
                .uri(builder -> builder.path("search")
                        .queryParam("key", apiKey) // API 키 추가
                        .queryParam("part", "snippet")
                        .queryParam("q", keyword)    // 검색 쿼리 추가
                        .build()
                )
                .retrieve()
                .bodyToMono(SearchDTO.class);
    }

    @GetMapping("/playlist")
    public Mono<PlayListDTO> searchPlaylists(@RequestParam String keyword) {
        return WebClient.builder().baseUrl("https://www.googleapis.com/youtube/v3/")
                .build().get()
                .uri(builder -> builder.path("search")
                        .queryParam("key", apiKey)
                        .queryParam("part", "snippet")
                        .queryParam("q", keyword)
                        .queryParam("maxResults", 10)   // 갯수 설정
                        .queryParam("type", "playlist") // 플레이리스트 검색
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PlayListDTO.class);
//                .map(response -> {
//
//                    // API 응답에서 플레이리스틎 정보 추출
//                    List<PlayListDTO> playLists = new ArrayList<>();
//                    for (Item item : response.getItems()) {
//                        if(item.getId().getKind().equals("youtube#playlist")) {
//                            PlayListDTO playListDTO = new PlayListDTO();
////                            playListDTO.setVideId(item.getId().getVideoId());
////                            playListDTO.setPlaylistId(item.getId().getPlaylistId());
////                            playListDTO.setPlaylistId(item.getSnippet().getDescription());
////                            playListDTO.setDescription(item.getSnippet().getDescription());
////                            playListDTO.setThumbnailUrl(String.valueOf(item.getSnippet().getThumbnails().getDefaultThumbnail()));
//                            playLists.add(playListDTO);
//                        }
//                    }
//                    return response;
//                });
    }
}
