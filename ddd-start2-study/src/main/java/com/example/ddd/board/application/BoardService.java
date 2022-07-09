package com.example.ddd.board.application;

import com.example.ddd.board.domain.Board;
import com.example.ddd.board.domain.BoardRepository;
import com.example.ddd.board.domain.Comment;
import com.example.ddd.board.domain.CommentRepository;
import com.example.ddd.board.presentation.CreateBoardRequest;
import com.example.ddd.board.presentation.CreateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public void createBoard(CreateBoardRequest request) {
        boardRepository.save(Board.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .build());
    }

    public void createComment(Long boardId, CreateCommentRequest request) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        commentRepository.save(Comment.builder()
                .board(board)
                .comments(request.getComments())
                .build());
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public void deleteComment(Long boardId, Long commentId) {
        Board board = boardRepository.findWithCommentsById(boardId).orElseThrow();
        board.deleteCommentById(commentId);
    }
}
