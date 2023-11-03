package com.team.CoverSongChart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SwaggerController {

    @GetMapping
    public String showSample() {

        return "Hello World";
    }
}
