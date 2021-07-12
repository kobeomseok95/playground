package com.example.awsec2s3practice.services.interfaces;

import com.example.awsec2s3practice.dtos.BoardDto;
import com.example.awsec2s3practice.dtos.BoardResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    Long createBoard(BoardDto boardDto, List<MultipartFile> file);

    BoardResponseDto getBoard(Long id);

    void updateBoard(Long id, BoardDto boardDto, List<MultipartFile> file);

    void deleteBoard(Long id);
}
