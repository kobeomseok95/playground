package com.demo.querydslexample.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TeamMembersDto implements Serializable {

    private Long teamId;
    private String teamName;
    private List<TeamMember> teamMembers = new ArrayList<>();

    @Data
    public static class TeamMember implements Serializable {

        private Long memberId;
        private String username;
        private int age;
    }
}
