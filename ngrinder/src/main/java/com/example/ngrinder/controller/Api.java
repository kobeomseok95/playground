package com.example.ngrinder.controller;

import com.example.ngrinder.dto.ArticleDto;
import com.example.ngrinder.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class Api {

    private final ArticleService articleService;

    @PostMapping
    public String post(@RequestBody ArticleDto articleDto) {
        articleService.post(articleDto);
        return "post";
    }

    @PostMapping(value = "/image", consumes =  {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String postImage(@RequestHeader(value = "Authorization") String header,
                            @RequestPart("files") List<MultipartFile> files,
                            @RequestPart("json") ArticleDto articleDto) {
        log.warn("header = {}", header);
        articleService.postImage(files, articleDto);
        return "post with image";
    }

    @GetMapping("/{id}")
    public ArticleDto get(@PathVariable Long id) {
        return articleService.get(id);
    }

    @PutMapping("/{id}")
    public String put(@PathVariable Long id, @RequestBody ArticleDto articleDto) {
        articleService.put(id, articleDto);
        return "put";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        articleService.delete(id);
        return "delete";
    }
}
