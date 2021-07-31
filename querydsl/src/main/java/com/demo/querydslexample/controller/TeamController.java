package com.demo.querydslexample.controller;

import com.demo.querydslexample.dto.TeamMembersDto;
import com.demo.querydslexample.repository.TeamRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepositoryCustom teamRepository;

    @GetMapping("/team/{teamId}")
    public List<TeamMembersDto> getTeam(@PathVariable("teamId") Long teamId) {
        List<TeamMembersDto> search = teamRepository.search(teamId);
        return search;
    }
}
