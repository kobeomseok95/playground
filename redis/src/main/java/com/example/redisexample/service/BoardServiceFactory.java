package com.example.redisexample.service;

import com.example.redisexample.dto.CommentDto;
import com.example.redisexample.dto.ContentDto;
import com.example.redisexample.dto.Create;
import com.example.redisexample.dto.InfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class BoardServiceFactory {

    private final BoardService boardService;

    public String process(Create create, List<MultipartFile> infoFile) {
        if (create.getCreateType().equals(Create.CreateType.INFO)) {
            return boardService.saveInfo((InfoDto) create, infoFile);
        } else if (create.getCreateType().equals(Create.CreateType.CONTENT)) {
            return boardService.saveContent((ContentDto) create, infoFile);
        } else if (create.getCreateType().equals(Create.CreateType.COMMENT)) {
            return boardService.saveComment((CommentDto) create, infoFile);
        }
        return "NULL";
    }
}
