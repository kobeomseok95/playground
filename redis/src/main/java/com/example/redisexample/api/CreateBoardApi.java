package com.example.redisexample.api;

import com.example.redisexample.service.BoardService;
import com.example.redisexample.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class CreateBoardApi {

    private final BoardService boardService;

    @PostMapping(value = "", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String temporarySave(@RequestPart(name = "board") Board board,
                                @RequestPart(name = "contentFile", required = false) List<MultipartFile> contentFiles,
                                @RequestPart(name = "profile", required = false) MultipartFile profile) {
        return boardService.save(board, contentFiles, profile);
    }

    @GetMapping("/{boardId}")
    public Board getBoard(@PathVariable String boardId) {
        return boardService.getBoard(boardId);
    }
}
