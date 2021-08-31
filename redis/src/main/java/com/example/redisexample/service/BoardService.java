package com.example.redisexample.service;

import com.example.redisexample.vo.Board;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    String save(Board board, List<MultipartFile> contentFiles, MultipartFile profile);

    Board getBoard(String boardId);
}
