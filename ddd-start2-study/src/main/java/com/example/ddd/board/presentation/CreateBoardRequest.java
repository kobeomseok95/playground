package com.example.ddd.board.presentation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBoardRequest {

    private String title;
    private String contents;
}
