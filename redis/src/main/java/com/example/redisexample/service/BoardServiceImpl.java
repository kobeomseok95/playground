package com.example.redisexample.service;

import antlr.StringUtils;
import com.example.redisexample.repository.BoardRedisRepository;
import com.example.redisexample.vo.BoardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRedisRepository boardRedisRepository;
    private final String USERNAME = "123123";

    @Override
    public String save(BoardForm boardForm,
                       MultipartFile infoFile,
                       List<MultipartFile> contentFiles,
                       List<MultipartFile> commentFiles) {
        deletePreviousBoard();
        saveFiles(boardForm, infoFile, contentFiles, commentFiles);
        boardForm.setId(USERNAME);
        return boardRedisRepository.save(boardForm).getId();
    }

    private void deletePreviousBoard() {
        Optional<BoardForm> findBoardForm = boardRedisRepository.findById(USERNAME);
        findBoardForm.ifPresent(this::deleteFiles);
    }

    private void deleteFiles(BoardForm findBoardForm) {
        List<String> filesNames = findBoardForm.getFilesNames();
        filesNames.forEach(fileName -> System.out.println(fileName + "지움!"));
    }

    // 템플릿 메서드 패턴으로 개선 해봐도 좋을듯.
    private void saveFiles(BoardForm boardForm, MultipartFile infoFile, List<MultipartFile> contentFiles, List<MultipartFile> commentFiles) {
        saveInfoFile(boardForm, infoFile);
        saveContentFile(boardForm, contentFiles);
        saveCommentFile(boardForm, commentFiles);
    }

    private void saveInfoFile(BoardForm boardForm, MultipartFile infoFile) {
        if (infoFile == null) {
            return;
        }
        boardForm.getInfo().setProfileUrl(infoFile.getOriginalFilename() + UUID.randomUUID());
    }

    private void saveContentFile(BoardForm boardForm, List<MultipartFile> contentFiles) {
        if (fileListIsEmpty(contentFiles)) {
            return;
        }
        boardForm.setContentFiles(contentFiles);
    }

    private void saveCommentFile(BoardForm boardForm, List<MultipartFile> commentFiles) {
        if (fileListIsEmpty(commentFiles)) {
            return;
        }
        boardForm.setCommentFiles(commentFiles);
    }

    private boolean fileListIsEmpty(List<MultipartFile> files) {
        if (files.isEmpty()) {
            return true;
        }
        if (files.size() == 1 && files.get(0).getOriginalFilename().equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public BoardForm getBoard(String boardId) {
        return boardRedisRepository.findById(boardId).orElseThrow();
    }
}
