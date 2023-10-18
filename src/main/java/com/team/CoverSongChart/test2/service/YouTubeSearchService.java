package com.team.CoverSongChart.test2.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class YouTubeSearchService {

    private final YouTube youtube;

    public String searchShortBox(String keyword) throws IOException {
        YouTube.Search.List search = youtube.search().list("snippet");
        search.setQ(keyword);
//        search.setMaxResults(10L); // 검색제한 갯수 원하면 하기
        SearchListResponse searchResponse = search.execute();
        return searchResponse.toPrettyString();
    }
}
