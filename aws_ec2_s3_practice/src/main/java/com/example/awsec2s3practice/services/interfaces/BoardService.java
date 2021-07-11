package com.example.awsec2s3practice.services.interfaces;

import com.example.awsec2s3practice.dtos.BoardDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    Long createBoard(BoardDto boardDto, List<MultipartFile> file);

    BoardDto getBoard(Long id);

    Long updateBoard(Long id);

    Long deleteBoard(Long id);
}
