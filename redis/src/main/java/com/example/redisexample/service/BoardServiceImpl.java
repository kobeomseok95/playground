package com.example.redisexample.service;

import com.example.redisexample.dto.CommentDto;
import com.example.redisexample.dto.ContentDto;
import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.repository.BoardRedisRepository;
import com.example.redisexample.vo.BoardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public String saveInfo(InfoDto infoDto, List<MultipartFile> infoFile) {
        BoardForm board = boardRedisRepository.save(BoardForm.builder().id(USERNAME)
                .info(BoardForm.Info.builder()
                        .name(infoDto.getName())
                        .nickname(infoDto.getNickname())
                        .profileUrl("테스트")
                        .build())
                .build());
        return board.getId();

//        return boardRedisRepository.findById(USERNAME)
//                .map(form -> putBoard(form, infoDto, infoFile))
//                .orElseGet(() -> saveBoard(infoDto, infoFile));
    }

    private String putBoard(BoardForm boardForm, InfoDto infoDto, List<MultipartFile> infoFile) {
        deleteFile(boardForm.getInfo().getProfileUrl());
        boardForm.setInfo(infoDto, saveFiles(infoFile));
        boardRedisRepository.save(boardForm);
        return "put Board";
    }

    private void deleteFile(String profileUrl) {
        System.out.println("================= "+ profileUrl + " 지우기 완료!");
    }

    private String saveBoard(InfoDto infoDto, List<MultipartFile> infoFile) {
        BoardForm boardForm = BoardForm.builder()
                .id(USERNAME)
                .info(BoardForm.Info.builder()
                        .name(infoDto.getName())
                        .nickname(infoDto.getNickname())
                        .profileUrl(saveFiles(infoFile))
                        .build())
                .build();
        boardRedisRepository.save(boardForm);
        return "save Board";
    }

    private String saveFiles(List<MultipartFile> infoFile) {
        String rename = infoFile.get(0).getOriginalFilename() + UUID.randomUUID();
        System.out.println("================= "+ rename + " 생성 완료!");
        return rename;
    }

    @Override
    public String saveContent(ContentDto contentDto, List<MultipartFile> contentFiles) {
        BoardForm boardForm = boardRedisRepository.findById(USERNAME).orElseThrow();
        putContent(boardForm, contentDto, contentFiles);
        boardRedisRepository.save(boardForm);
        return "save Content";
    }

    private void putContent(BoardForm boardForm, ContentDto contentDto, List<MultipartFile> contentFiles) {
        deleteFiles(boardForm.getContentList().stream().map(BoardForm.Content::getProfileUrl).collect(Collectors.toList()));
        saveFiles(contentFiles);
        boardForm.setContent(List.of(contentDto));
    }

    private void deleteFiles(List<String> fileNames) {
        fileNames.forEach(fileName -> System.out.println(fileName + " 삭제 완료!"));
    }

    @Override
    public String saveComment(CommentDto commentDto, List<MultipartFile> commentFiles) {

        return "saveComment";
    }
}
