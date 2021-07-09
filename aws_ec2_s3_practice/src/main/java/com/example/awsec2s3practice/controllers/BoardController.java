package com.example.awsec2s3practice.controllers;

import com.example.awsec2s3practice.services.interfaces.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardID}")
    public void getBoard(@PathVariable("boardID") String boardId) {

    }

    @PostMapping("/")
    public void createBoard(@RequestPart MultipartFile files) {

    }

    @PatchMapping("/{boardID}")
    public void updateBoard(@PathVariable("boardID") String boardId) {

    }

    @DeleteMapping("/{boardID}")
    public void deleteBoard(@PathVariable("boardID") String boardId) {

    }
}
