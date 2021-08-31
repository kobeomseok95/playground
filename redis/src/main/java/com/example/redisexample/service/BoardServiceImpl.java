package com.example.redisexample.service;

import com.example.redisexample.repository.BoardRedisRepository;
import com.example.redisexample.vo.Board;
import com.example.redisexample.vo.FileVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRedisRepository boardRedisRepository;

    @Override
    public String save(Board board, List<MultipartFile> contentFiles, MultipartFile profile) {

        Optional<Board> findBoard = boardRedisRepository.findById(board.getId());
        if (findBoard.isPresent()) {
            List<String> fileNames = findBoard.get().getFileNames();
            deleteFiles(fileNames);
        }

        List<FileVo> contentVoList = createFiles(contentFiles);
        List<FileVo> profileVo = createFiles(List.of(profile));
        board.setContentFile(contentVoList);
        board.setProfile(profileVo);

        return boardRedisRepository.save(board).getId();
    }

    private void deleteFiles(List<String> fileNames) {
        fileNames.forEach(fileName -> System.out.println(fileName + "지우기!"));
    }

    private List<FileVo> createFiles(List<MultipartFile> contentFiles) {
        return contentFiles.stream()
                .map(file -> FileVo.of(file.getOriginalFilename(), UUID.randomUUID().toString()))
                .collect(toList());
    }

    @Override
    public Board getBoard(String boardId) {
        return boardRedisRepository.findById(boardId).orElseThrow();
    }
}
