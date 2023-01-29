package com.example.batch.job.file.core.domain;

import lombok.Data;

@Data
public class Player {

    private String ID;
    private String lastName;
    private String firstName;
    private String position;
    private int birthYear;
    private int debutYear;

    public Player(String ID, String lastName, String firstName, String position, int birthYear, int debutYear) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.birthYear = birthYear;
        this.debutYear = debutYear;
    }
}
