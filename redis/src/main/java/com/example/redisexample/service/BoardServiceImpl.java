package com.example.redisexample.service;

import com.example.redisexample.dto.CommentDto;
import com.example.redisexample.dto.ContentDto;
import com.example.redisexample.dto.Create;
import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.repository.BoardRedisRepository;
import com.example.redisexample.vo.BoardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRedisRepository boardRedisRepository;
    private final String USERNAME = "123";

    @Override
    public BoardForm getBoard(String boardId) {
        return boardRedisRepository.findById(boardId).orElseThrow();
    }

    @Override
    public String saveInfo(InfoDto infoDto, MultipartFile infoFile) {
        return boardRedisRepository.findById(USERNAME)
                .map(form -> putBoard(form, infoDto, infoFile))
                .orElseGet(() -> saveBoard(infoDto, infoFile));
    }

    private String putBoard(BoardForm boardForm, InfoDto infoDto, MultipartFile infoFile) {
        deleteFile(boardForm.getInfo().getProfileUrl());
        boardForm.setInfo(infoDto, saveFile(infoFile));
        boardRedisRepository.save(boardForm);
        return "put Board";
    }

    private void deleteFile(String profileUrl) {
        System.out.println("================= "+ profileUrl + " 지우기 완료!");
    }

    private String saveBoard(InfoDto infoDto, MultipartFile infoFile) {
        BoardForm boardForm = BoardForm.builder()
                .id(USERNAME)
                .info(BoardForm.Info.builder()
                        .name(infoDto.getName())
                        .nickname(infoDto.getNickname())
                        .profileUrl(saveFile(infoFile))
                        .build())
                .build();
        boardRedisRepository.save(boardForm);
        return "save Board";
    }

    private String saveFile(MultipartFile infoFile) {
        String rename = infoFile.getOriginalFilename() + UUID.randomUUID();
        System.out.println("================= "+ rename + " 생성 완료!");
        return rename;
    }

    @Override
    public String saveContent(ContentDto contentDto, List<MultipartFile> contentFiles) {

        return "saveContent";
    }

    @Override
    public String saveComment(CommentDto commentDto, List<MultipartFile> commentFiles) {

        return "saveComment";
    }
}
