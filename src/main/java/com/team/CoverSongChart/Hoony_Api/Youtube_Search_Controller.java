package com.team.CoverSongChart.Hoony_Api;

import com.team.CoverSongChart.Hoony_Api.Dto.YouTubeApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
public class Youtube_Search_Controller {

    @Value("${youtube.api.key}")
    private String apiKey;

    @GetMapping("/search")
    @ResponseBody
    public Mono<YouTubeApiResponse> search(@RequestParam String keyword) {
        return WebClient.builder().baseUrl("https://www.googleapis.com/youtube/v3/")
                .build().get()
                .uri(builder -> builder.path("search")
                        .queryParam("key", apiKey) // API 키 추가
                        .queryParam("part", "snippet")
                        .queryParam("q", keyword)    // 검색 쿼리 추가
                        .build()
                )
                .retrieve()
                .bodyToMono(YouTubeApiResponse.class);
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

}
