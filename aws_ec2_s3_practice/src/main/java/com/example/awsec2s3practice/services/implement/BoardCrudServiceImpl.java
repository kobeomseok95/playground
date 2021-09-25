package com.example.awsec2s3practice.services.implement;

import com.example.awsec2s3practice.entities.Board;
import com.example.awsec2s3practice.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCrudServiceImpl {

    private final BoardRepository boardRepository;

    public List<Board> getBoardsForMaster() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Board> getBoardsForSlave() {
        return boardRepository.findAll();
    }
}
