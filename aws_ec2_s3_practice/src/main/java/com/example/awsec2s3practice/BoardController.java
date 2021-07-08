package com.example.awsec2s3practice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @GetMapping("/{boardID}")
    public void getBoard(@PathVariable("boardID") String boardId) {

    }

    @PostMapping("/")
    public void createBoard() {

    }

    @PatchMapping("/{boardID}")
    public void updateBoard(@PathVariable("boardID") String boardId) {

    }

    @DeleteMapping("/{boardID}")
    public void deleteBoard(@PathVariable("boardID") String boardId) {

    }
}
