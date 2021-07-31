package com.demo.querydslexample.repository;

import com.demo.querydslexample.dto.TeamMembersDto;

import java.util.List;

public interface TeamRepositoryCustom {

    List<TeamMembersDto> search(Long teamId);
}
