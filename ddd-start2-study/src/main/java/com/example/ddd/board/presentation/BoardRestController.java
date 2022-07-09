package com.example.ddd.board.presentation;

import com.example.ddd.board.application.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardRestController {

    private final BoardService boardService;

    @PostMapping("")
    public void createBoard(@RequestBody CreateBoardRequest request) {
        boardService.createBoard(request);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }

    @PostMapping("/{boardId}/comments")
    public void createComment(@PathVariable Long boardId,
                              @RequestBody CreateCommentRequest request) {
        boardService.createComment(boardId, request);
    }

    @DeleteMapping("/{boardId}/comments/{commentId}")
    public void deleteBoard(@PathVariable Long boardId,
                            @PathVariable Long commentId) {
        boardService.deleteComment(boardId, commentId);
    }
}
