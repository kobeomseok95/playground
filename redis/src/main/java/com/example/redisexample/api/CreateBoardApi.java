package com.example.redisexample.api;

import com.example.redisexample.dto.CommentDto;
import com.example.redisexample.dto.ContentDto;
import com.example.redisexample.dto.Create;
import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.service.BoardService;
import com.example.redisexample.service.BoardServiceFactory;
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
    private final BoardServiceFactory boardServiceFactory;

    @PostMapping(value = "", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String save(@RequestPart("create") Create create,
                                    @RequestPart(value = "image") List<MultipartFile> files) {
        return boardServiceFactory.process(create, files);
    }

    @PostMapping(value = "/content", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String temporarySaveContent(@RequestPart("content") ContentDto contentDto,
                                       @RequestPart(value = "contentImage", required = false) List<MultipartFile> contentFiles) {
        return boardService.saveContent(contentDto, contentFiles);
    }

    @PostMapping(value = "/comment", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String temporarySaveContent(@RequestPart("comment") CommentDto commentDto,
                                       @RequestPart(value = "commentImage", required = false) List<MultipartFile> commentFiles) {
        return boardService.saveComment(commentDto, commentFiles);
    }

    @GetMapping("/{boardId}")
    public BoardForm getBoard(@PathVariable String boardId) {
        return boardService.getBoard(boardId);
    }
}
