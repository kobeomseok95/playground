package com.example.redisexample.api;

import com.example.redisexample.service.BoardService;
import com.example.redisexample.vo.BoardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String temporarySave(@RequestPart("board") BoardForm boardForm,
                                @RequestPart(value = "infoImage", required = false) MultipartFile infoFile,
                                @RequestPart(value = "contentImage", required = false) List<MultipartFile> contentFiles,
                                @RequestPart(value = "commentImage", required = false) List<MultipartFile> commentFiles) {
        return boardService.save(boardForm, infoFile, contentFiles, commentFiles);
    }


    @GetMapping("/{boardId}")
    public BoardForm getBoard(@PathVariable String boardId) {
        return boardService.getBoard(boardId);
    }
}
