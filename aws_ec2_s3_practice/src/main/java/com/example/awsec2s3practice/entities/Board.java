package com.example.awsec2s3practice.entities;

import com.example.awsec2s3practice.dtos.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Lob
    @Column(name = "imageurl")
    private String imageURL;

    @Column(name = "file_name")
    private String fileName;

    public static Board from(BoardDto boardDto) {

        return  Board.builder()
                .title(boardDto.getTitle())
                .text(boardDto.getText())
                .imageURL("")
                .fileName("")
                .build();
    }

    public static Board of(BoardDto boardDto, String fileNames, String fileURL) {

        return Board.builder()
                .imageURL(fileURL)
                .fileName(fileNames)
                .title(boardDto.getTitle())
                .text(boardDto.getText())
                .build();
    }

    public void updateBoard(BoardDto boardDto, String newFilenames, String newFileURLs) {

        title = boardDto.getTitle();
        text = boardDto.getText();
        imageURL = newFileURLs;
        fileName = newFilenames;
    }

    public void updateBoard(BoardDto boardDto) {

        title = boardDto.getTitle();
        text = boardDto.getText();
        imageURL = "";
        fileName = "";
    }
}
