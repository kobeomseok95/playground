package com.example.ddd.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String contents;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "board"
    )
    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteCommentById(Long commentId) {
        comments.removeIf(comment -> comment.getId().equals(commentId));
    }
}
