package com.example.awsec2s3practice.controllers;

import com.example.awsec2s3practice.dtos.BoardDto;
import com.example.awsec2s3practice.services.interfaces.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardID}")
    public void getBoard(@PathVariable("boardID") String boardId) {

    }

    @PostMapping(value = "/", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String createBoard(@RequestPart(name = "dto") BoardDto boardDto,
                              @RequestPart(name = "file", required = false) MultipartFile file) {

        return boardService.createBoard(boardDto, file).toString();
    }

    @PatchMapping("/{boardID}")
    public void updateBoard(@PathVariable("boardID") String boardId) {

    }

    @DeleteMapping("/{boardID}")
    public void deleteBoard(@PathVariable("boardID") String boardId) {

    }
}
