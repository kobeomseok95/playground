package com.example.redisexample.service;

import com.example.redisexample.dto.CommentDto;
import com.example.redisexample.dto.ContentDto;
import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.vo.BoardForm;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    BoardForm getBoard(String boardId);

    String saveInfo(InfoDto infoDto, MultipartFile infoFile);

    String saveContent(ContentDto contentDto, List<MultipartFile> contentFiles);

    String saveComment(CommentDto commentDto, List<MultipartFile> commentFiles);
}
