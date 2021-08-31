package com.example.redisexample.service;

import com.example.redisexample.vo.BoardForm;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    String save(BoardForm boardForm,
                MultipartFile infoFile,
                List<MultipartFile> contentFiles,
                List<MultipartFile> commentFiles);

    BoardForm getBoard(String boardId);
}
