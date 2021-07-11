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
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    @Lob
    private String imageURL;

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
}
