package com.example.awsec2s3practice.controllers;

import com.example.awsec2s3practice.dtos.BoardDto;
import com.example.awsec2s3practice.dtos.BoardResponseDto;
import com.example.awsec2s3practice.services.interfaces.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardID}")
    public BoardResponseDto getBoard(@PathVariable("boardID") Long boardId) {

        return boardService.getBoard(boardId);
    }

    @PostMapping(value = "/", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String createBoard(@RequestPart(name = "dto") BoardDto boardDto,
                              @RequestPart(name = "file", required = false) List<MultipartFile> files) {

        return boardService.createBoard(boardDto, files).toString();
    }

    @PutMapping(value = "/{boardID}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public void updateBoard(@PathVariable("boardID") Long boardId,
                            @RequestPart(name = "dto") BoardDto boardDto,
                            @RequestPart(name = "file", required = false) List<MultipartFile> files) {

        boardService.updateBoard(boardId, boardDto, files);
    }

    @DeleteMapping("/{boardID}")
    public void deleteBoard(@PathVariable("boardID") Long boardId) {

        boardService.deleteBoard(boardId);
    }
}
