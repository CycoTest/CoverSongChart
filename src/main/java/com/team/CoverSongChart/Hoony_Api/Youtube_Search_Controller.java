package com.team.CoverSongChart.Hoony_Api;

import com.team.CoverSongChart.Hoony_Api.Dto.playListDTO.PlaylistDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Youtube_Search_Controller {

    @Value("${youtube.api.key}")
    private String apiKey;

//    @GetMapping("/search")
//    @ResponseBody
//    public Mono<YouTubeApiResponse> search(@RequestParam String keyword) {
//        return WebClient.builder().baseUrl("https://www.googleapis.com/youtube/v3/")
//                .build().get()
//                .uri(builder -> builder.path("search")
//                        .queryParam("key", apiKey) // API 키 추가
//                        .queryParam("part", "snippet")
//                        .queryParam("q", keyword)    // 검색 쿼리 추가
//                        .build()
//                )
//                .retrieve()
//                .bodyToMono(YouTubeApiResponse.class);
//    }

    @GetMapping("/search")
    @ResponseBody
    public Mono<List<PlaylistDTO>> searchPlaylists(@RequestParam String keyword) {
        return WebClient.builder().baseUrl("https://www.googleapis.com/youtube/v3/")
                .build().get()
                .uri(builder -> builder.path("search")
                        .queryParam("key", apiKey)
                        .queryParam("part", "snippet")
                        .queryParam("q", keyword)
                        .queryParam("type", "playlist") // 플레이리스트 검색
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(YouTubeApiResponse.class)
                .map(response -> {
                    // API 응답에서 플레이리스트 정보 추출
                    List<PlaylistDTO> playlists = new ArrayList<>();
                    for (Item item : response.getItems()) {
                        if (item.getId().getKind().equals("youtube#playlist")) {
                            PlaylistDTO playlistDTO = new PlaylistDTO();
                            playlistDTO.setPlaylistId(item.getId().getPlaylistId());
                            playlistDTO.setTitle(item.getSnippet().getTitle());
                            playlistDTO.setDescription(item.getSnippet().getDescription());
                            playlistDTO.setThumbnailUrl(item.getSnippet().getThumbnails().getDefaultThumbnail().getUrl());
                            playlists.add(playlistDTO);
                        }
                    }
                    return playlists;
                });
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

}
